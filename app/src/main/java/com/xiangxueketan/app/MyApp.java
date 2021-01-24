package com.xiangxueketan.app;
import android.app.Application;
import com.xiangxueketan.mvvm.v1.base.NetworkApi;
/**
 * @Description: application android启动先执行的
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/23 下午6:38
 * @Version: 1.0
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetworkApi.init(new NetworkRequestInfo(this));
    }
}
