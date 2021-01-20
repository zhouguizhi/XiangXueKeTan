package com.zgz.reflect.net;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午4:18
 * @Version: 1.0
 */
public  abstract  class Callback<T>{
    public abstract void onSuccess(T t);
    public abstract void onFail();
}
