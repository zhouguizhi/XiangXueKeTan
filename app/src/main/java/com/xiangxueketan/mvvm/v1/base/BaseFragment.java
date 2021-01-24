package com.xiangxueketan.mvvm.v1.base;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
/**
 * @Description: fragment的封装
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:04
 * @Version: 1.0
 */
public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    public T mBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, loadLayoutId(), container, false);
        Log.e("zhouguizhi","mBinding:="+mBinding);
        init();
        View view = null;
        if(null!=mBinding){
            view =  mBinding.getRoot();
        }
        return view;
    }
    public abstract int loadLayoutId();
    public abstract void init();
}
