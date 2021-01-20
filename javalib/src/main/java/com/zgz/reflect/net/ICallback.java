package com.zgz.reflect.net;
/**
 * @Description: 模拟请求返回的回调
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午5:04
 * @Version: 1.0
 */
public interface ICallback<T> {
    void onSuccess(T t);
}
