package com.xiangxueketan.mvvm.v1.fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.FragmentCategoryBinding;
import com.xiangxueketan.mvvm.v1.base.BaseFragment;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:01
 * @Version: 1.0
 */
public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int loadLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void init() {
        mBinding.homeTxtTitle.setText("地区");
    }
}
