package com.xiangxueketan.mvvm.v1.base.mvvm.model;
/**
 * @Description: 网络请求的回调
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/25 下午7:55
 * @Version: 1.0
 */
public interface IBaseModelListener<DATA> {
    void onLoadSuccess(DATA data);
    void onLoadFail(Throwable throwable);
}
