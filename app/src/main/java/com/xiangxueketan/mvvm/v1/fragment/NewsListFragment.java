package com.xiangxueketan.mvvm.v1.fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentNewsBinding;
import com.xiangxueketan.mvvm.v1.adapter.NewsListRecyclerViewAdapter;
import com.xiangxueketan.mvvm.v1.api.NewsApiInterface;
import com.xiangxueketan.mvvm.v1.base.BaseCustomViewModel;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
import com.xiangxueketan.mvvm.v1.bean.NewsListBean;
import com.xiangxueketan.mvvm.v1.fragment.views.pictruetitleview.PictureViewModel;
import com.xiangxueketan.mvvm.v1.fragment.views.titleview.TitleViewModel;
import com.xiangxueketan.mvvm.v1.net.TecentNetworkApi;
import com.xiangxueketan.mvvm.v1.net.observer.BaseObserver;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 头条fragment
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:38
 * @Version: 1.0
 */
public class NewsListFragment extends BaseFragment<FragmentNewsBinding> {
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_ID = "bundle_key_param_channel_id";
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_NAME = "bundle_key_param_channel_name";
    private List<BaseCustomViewModel> viewModelList = new ArrayList<>();
    private int mPage = 1;
    private NewsListRecyclerViewAdapter mAdapter;
    public static Fragment newInstance(String channelId, String channelName) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_ID, channelId);
        bundle.putString(BUNDLE_KEY_PARAM_CHANNEL_NAME, channelName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int loadLayoutId() {
        return R.layout.fragment_news;
    }
    @Override
    public void init() {
        initAdapter();
        initListener();
        loadData();
    }

    private void initAdapter() {
        mAdapter = new NewsListRecyclerViewAdapter();
        mBinding.listview.setHasFixedSize(true);
        mBinding.listview.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.listview.setAdapter(mAdapter);
    }

    private void initListener() {
        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> {
            mPage = 0;
            loadData();
        });
        mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> loadData());
    }

    private void loadData() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsList(getArguments().getString(BUNDLE_KEY_PARAM_CHANNEL_ID),
                        getArguments().getString(BUNDLE_KEY_PARAM_CHANNEL_NAME), String.valueOf(mPage))
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsListBean>() {
                    @Override
                    public void onSuccess(NewsListBean newsChannelsBean) {
                        if(mPage == 0) {
                           viewModelList.clear();
                        }
                        for(NewsListBean.Contentlist contentlist:newsChannelsBean.showapiResBody.pagebean.contentlist){
                            if(contentlist.imageurls!=null&&!contentlist.imageurls.isEmpty()){
                                PictureViewModel pictureViewModel = new PictureViewModel();
                                pictureViewModel.title = contentlist.title;
                                pictureViewModel.jumpUrl = contentlist.link;
                                pictureViewModel.pictureUrl = contentlist.imageurls.get(0).url;
                                viewModelList.add(pictureViewModel);
                            }else{
                                TitleViewModel titleViewModel = new TitleViewModel();
                                titleViewModel.title = contentlist.title;
                                titleViewModel.jumpUrl = contentlist.link;
                                viewModelList.add(titleViewModel);
                            }
                        }
//                        contentlist.addAll(newsChannelsBean.showapiResBody.pagebean.contentlist);
                        mAdapter.setData(viewModelList);
                        mPage ++;
                        mBinding.refreshLayout.finishRefresh();
                        mBinding.refreshLayout.finishLoadMore();
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                    }
                }));
    }
}
