package com.xiangxueketan.mvvm.v1.commoninterceptor;
import android.util.Log;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/23 下午11:12
 * @Version: 1.0
 */
public class CommonResponseInterceptor implements Interceptor {
    private static final String TAG = "ResponseInterceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        Log.d(TAG, "requestTime="+ (System.currentTimeMillis() - requestTime));
        return response;
    }
}
