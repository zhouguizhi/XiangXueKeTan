package com.xiangxueketan.mvvm.v1.base;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
/**
 * @Description: 自定义view的抽取父类
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午11:33
 * @Version: 1.0
 */
public abstract class BaseView<T extends ViewDataBinding,D extends BaseCustomViewModel> extends LinearLayout implements IBaseCustomView<D>{
    public Context mContext;
    public LayoutInflater layoutInflater;
    public T mBinding;
    public D mViewModel;
    public BaseView(Context context) {
        this(context,null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
        mBinding = DataBindingUtil.inflate(layoutInflater, layoutId(),this,false);
        if(null!=mBinding){
            addView(mBinding.getRoot());
            mBinding.getRoot().setOnClickListener(this::onRootClickListener);
        }
    }
    public abstract void init();
    public abstract int layoutId();
    @Override
    public void setData(D data) {
        this.mViewModel = data;
        bindDataToView(data);
        mBinding.executePendingBindings();
    }
    public abstract void bindDataToView(D d);
    public abstract void onRootClickListener(View view);
}
