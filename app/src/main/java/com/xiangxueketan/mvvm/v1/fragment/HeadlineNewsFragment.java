package com.xiangxueketan.mvvm.v1.fragment;
import com.google.android.material.tabs.TabLayout;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentHeadLineNewBinding;
import com.xiangxueketan.mvvm.v1.adapter.HeadlineNewsFragmentAdapter;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
import com.xiangxueketan.mvvm.v1.base.mvvm.model.IBaseModelListener;
import com.xiangxueketan.mvvm.v1.bean.NewsChannelsBean;
import com.xiangxueketan.mvvm.v1.bean.PageResult;
import com.xiangxueketan.mvvm.v1.fragment.model.NewsChannelModel;
import java.util.List;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:01
 * @Version: 1.0
 */
public class HeadlineNewsFragment extends BaseFragment<FragmentHeadLineNewBinding> implements IBaseModelListener<List<NewsChannelsBean.ChannelList>> {
    private HeadlineNewsFragmentAdapter adapter;
    private NewsChannelModel newsChannelModel;
    @Override
    public int loadLayoutId() {
        return R.layout.fragment_head_line_new;
    }
    @Override
    public void init() {
        initViewModel();
        initAdapter();
        initViewPager();
    }

    private void initViewModel() {
        newsChannelModel = new NewsChannelModel(false);
        newsChannelModel.register(this);
        newsChannelModel.loadData();
    }
    private void initViewPager() {
        mBinding.viewpager.setOffscreenPageLimit(1);
    }

    private void initAdapter() {
        adapter = new HeadlineNewsFragmentAdapter(getChildFragmentManager());
        mBinding.tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mBinding.viewpager.setAdapter(adapter);
        mBinding.tablayout.setupWithViewPager(mBinding.viewpager);
    }
    @Override
    public void onLoadSuccess(List<NewsChannelsBean.ChannelList> channelLists, PageResult... pageResults) {
        if(null==adapter){
            return;
        }
        adapter.setChannels(channelLists);
    }
    @Override
    public void onLoadFail(Throwable throwable) {

    }
}
