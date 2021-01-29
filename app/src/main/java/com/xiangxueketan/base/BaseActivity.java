package com.xiangxueketan.base;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
/**
 * @Description: activity基类封装一些通过业务
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/29 上午9:43
 * @Version: 1.0
 */
public abstract class BaseActivity<VIEW extends ViewDataBinding> extends AppCompatActivity{
    public VIEW mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =  DataBindingUtil.inflate(LayoutInflater.from(this),loadLayoutId(),null,false);
        setContentView(mBinding.getRoot());
        init();
    }
    public abstract int loadLayoutId();
    public abstract void init();
}
