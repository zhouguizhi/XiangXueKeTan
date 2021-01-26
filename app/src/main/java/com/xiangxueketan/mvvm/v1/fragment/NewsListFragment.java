package com.xiangxueketan.mvvm.v1.fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentNewsBinding;
import com.xiangxueketan.mvvm.v1.adapter.NewsListRecyclerViewAdapter;
import com.xiangxueketan.mvvm.v1.base.BaseCustomViewModel;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
import com.xiangxueketan.mvvm.v1.base.mvvm.model.IBaseModelListener;
import com.xiangxueketan.mvvm.v1.bean.PageResult;
import com.xiangxueketan.mvvm.v1.fragment.model.NewsListModel;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 头条fragment
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:38
 * @Version: 1.0
 */
public class NewsListFragment extends BaseFragment<FragmentNewsBinding> implements IBaseModelListener<List<BaseCustomViewModel>> {
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_ID = "bundle_key_param_channel_id";
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_NAME = "bundle_key_param_channel_name";
    private List<BaseCustomViewModel> viewModelList = new ArrayList<>();
    private NewsListRecyclerViewAdapter mAdapter;
    private NewsListModel newsListModel;
    //
    private String channelId;
    private String channelName;

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
        initData();
        initAdapter();
        initListener();
        loadData();
    }

    private void initData() {
       Bundle bundle =  getArguments();
       if(null!=bundle){
           channelId =   bundle.getString(BUNDLE_KEY_PARAM_CHANNEL_ID);
           channelName = bundle.getString(BUNDLE_KEY_PARAM_CHANNEL_NAME);
       }
       newsListModel = new NewsListModel(channelId,channelName);
        newsListModel.register(this);
    }

    private void initAdapter() {
        mAdapter = new NewsListRecyclerViewAdapter();
        mBinding.listview.setHasFixedSize(true);
        mBinding.listview.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.listview.setAdapter(mAdapter);
    }

    private void initListener() {
        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> newsListModel.refreshData());
        mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> loadData());
    }

    private void loadData() {
        newsListModel.loadData();
    }
    @Override
    public void onLoadSuccess(List<BaseCustomViewModel> viewModel,PageResult... pageResults) {
        if(null==mAdapter){
            return;
        }
        if(null!=pageResults&&pageResults.length>0&&pageResults[0].isFirstPage()){
            viewModelList.clear();
        }
        loadFinish();
        viewModelList.addAll(viewModel);
        mAdapter.setData(viewModelList);
    }
    @Override
    public void onLoadFail(Throwable throwable) {
        loadFinish();
    }
    public void loadFinish(){
        mBinding.refreshLayout.finishRefresh();
        mBinding.refreshLayout.finishLoadMore();
    }
}
