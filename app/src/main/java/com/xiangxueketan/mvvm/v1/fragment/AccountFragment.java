package com.xiangxueketan.mvvm.v1.fragment;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentAccountBinding;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:02
 * @Version: 1.0
 */
public class AccountFragment extends BaseFragment<FragmentAccountBinding> {
    @Override
    public int loadLayoutId() {
        return R.layout.fragment_account;
    }

    @Override
    public void init() {
        mBinding.login.setText("我的");
    }
}
