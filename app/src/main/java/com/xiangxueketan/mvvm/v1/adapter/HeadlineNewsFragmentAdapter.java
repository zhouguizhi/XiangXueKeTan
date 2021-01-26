package com.xiangxueketan.mvvm.v1.adapter;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.xiangxueketan.mvvm.v1.bean.NewsChannelsBean;
import com.xiangxueketan.mvvm.v1.fragment.NewsListFragment;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:37
 * @Version: 1.0
 */
public class HeadlineNewsFragmentAdapter extends FragmentPagerAdapter {
    public static class Channel {
        public String channelId;
        public String channelName;
    }

    private List<NewsChannelsBean.ChannelList> mChannels;
    private HashMap<String, Fragment> fragmentHashMap = new HashMap<>();

    public HeadlineNewsFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setChannels(List<NewsChannelsBean.ChannelList> channels) {
        this.mChannels = channels;
        notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int pos) {
        String key = mChannels.get(pos).channelId + ":" + mChannels.get(pos).name;
        if (fragmentHashMap.get(key) != null) {
            return fragmentHashMap.get(key);
        }
        Fragment fragment = NewsListFragment.newInstance(mChannels.get(pos).channelId, mChannels.get(pos).name);
        fragmentHashMap.put(key, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        if (mChannels != null && mChannels.size() > 0) {
            return mChannels.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position).name;
    }
    @Override
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
