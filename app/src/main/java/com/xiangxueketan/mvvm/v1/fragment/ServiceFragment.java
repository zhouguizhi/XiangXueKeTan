package com.xiangxueketan.mvvm.v1.fragment;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentServiceBinding;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:01
 * @Version: 1.0
 */
public class ServiceFragment extends BaseFragment<FragmentServiceBinding> {
    @Override
    public int loadLayoutId() {
        return R.layout.fragment_service;
    }
    @Override
    public void init() {
        mBinding.homeTxtTitle.setText("服务");
    }
}
