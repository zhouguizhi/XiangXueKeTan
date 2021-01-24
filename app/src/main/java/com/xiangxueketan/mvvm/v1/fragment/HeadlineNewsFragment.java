package com.xiangxueketan.mvvm.v1.fragment;
import android.util.Log;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentHeadLineNewBinding;
import com.xiangxueketan.mvvm.v1.adapter.HeadlineNewsFragmentAdapter;
import com.xiangxueketan.mvvm.v1.api.NewsApiInterface;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
import com.xiangxueketan.mvvm.v1.bean.NewsChannelsBean;
import com.xiangxueketan.mvvm.v1.net.TecentNetworkApi;
import com.xiangxueketan.mvvm.v1.net.observer.BaseObserver;
import java.util.ArrayList;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:01
 * @Version: 1.0
 */
public class HeadlineNewsFragment extends BaseFragment<FragmentHeadLineNewBinding> {
    private HeadlineNewsFragmentAdapter adapter;
    @Override
    public int loadLayoutId() {
        return R.layout.fragment_head_line_new;
    }
    @Override
    public void init() {
        initAdapter();
        initViewPager();
        loadData();
    }
    private void loadData() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>() {
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {
                        Log.e("zhouguizhi", new Gson().toJson(newsChannelsBean));
                        ArrayList<HeadlineNewsFragmentAdapter.Channel> channels = new ArrayList<>();
                        for (NewsChannelsBean.ChannelList source : newsChannelsBean.showapiResBody.channelList) {
                            HeadlineNewsFragmentAdapter.Channel channel = new HeadlineNewsFragmentAdapter.Channel();
                            channel.channelId = source.channelId;
                            channel.channelName = source.name;
                            channels.add(channel);
                        }
                        adapter.setChannels(channels);
                    }
                    @Override
                    public void onFailure(Throwable e) {
                        Log.e("zhouguizhi", "error:="+e.getMessage());
                        e.printStackTrace();
                    }
                }));
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
}
