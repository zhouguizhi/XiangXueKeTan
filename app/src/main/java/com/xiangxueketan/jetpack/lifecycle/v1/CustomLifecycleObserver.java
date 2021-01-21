package com.xiangxueketan.jetpack.lifecycle.v1;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
/**
 * @Description: 实现LifecycleObserver接口,让自定义类成为观察者
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/21 上午10:09
 * @Version: 1.0
 */
public class CustomLifecycleObserver implements LifecycleObserver {
     @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
     void onCreate() {
         Log.e("zhouguizhi","Activity被创建了");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.e("zhouguizhi","Activity被销毁了");
    }
}
