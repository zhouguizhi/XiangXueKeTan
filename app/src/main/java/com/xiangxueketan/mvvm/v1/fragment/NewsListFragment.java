package com.xiangxueketan.mvvm.v1.fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentNewsBinding;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:38
 * @Version: 1.0
 */
public class NewsListFragment extends BaseFragment<FragmentNewsBinding> {
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_ID = "bundle_key_param_channel_id";
    protected final static String BUNDLE_KEY_PARAM_CHANNEL_NAME = "bundle_key_param_channel_name";
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

    }
}
