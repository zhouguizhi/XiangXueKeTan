package com.xiangxueketan.mvvm.v1.base.mvvm.model;
import java.lang.ref.WeakReference;
/**
 * @Description: model 业务的封装成BaseMVVMModel
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/26 下午12:36
 * @Version: 1.0
 */
public class BaseMVVMModel {
    //避免内存泄露  为什么会出现内存泄露
    public WeakReference<IBaseModelListener> mWeakReference;
    public int mPage = 1;
    public void register(IBaseModelListener iBaseModelListener){
        if(null!=iBaseModelListener){
            mWeakReference = new WeakReference<>(iBaseModelListener);
        }
    }
}
