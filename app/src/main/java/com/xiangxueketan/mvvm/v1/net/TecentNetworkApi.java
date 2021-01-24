package com.xiangxueketan.mvvm.v1.net;
import com.xiangxueketan.mvvm.v1.base.NetworkApi;
import com.xiangxueketan.mvvm.v1.bean.TecentBaseResponse;
import com.xiangxueketan.mvvm.v1.bean.UrlConfig;
import com.xiangxueketan.mvvm.v1.net.errorhandler.ExceptionHandle;
import com.xiangxueketan.mvvm.v1.util.TecentUtil;
import java.io.IOException;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:41
 * @Version: 1.0
 */
public class TecentNetworkApi extends NetworkApi {
    private static volatile TecentNetworkApi sInstance;

    public static TecentNetworkApi getInstance() {
        if (sInstance == null) {
            synchronized (TecentNetworkApi.class) {
                if (sInstance == null) {
                    sInstance = new TecentNetworkApi();
                }
            }
        }
        return sInstance;
    }
    public static  <T> T getService(Class<T> service) {
        return getInstance().getRetrofit(service).create(service);
    }
    @Override
    protected Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String timeStr = TecentUtil.getTimeStr();
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Source", "source");
                builder.addHeader("Authorization", TecentUtil.getAuthorization(timeStr));
                builder.addHeader("Date", timeStr);
                return chain.proceed(builder.build());
            }
        };
    }
    protected <T> Function<T, T> getAppErrorHandler() {
        return new Function<T, T>() {
            @Override
            public T apply(T response) throws Exception {
                //response中code码不会0 出现错误
                if (response instanceof TecentBaseResponse && ((TecentBaseResponse) response).showapiResCode != 0) {
                    ExceptionHandle.ServerException exception = new ExceptionHandle.ServerException();
                    exception.code = ((TecentBaseResponse) response).showapiResCode;
                    exception.message = ((TecentBaseResponse) response).showapiResError != null ? ((TecentBaseResponse) response).showapiResError : "";
                    throw exception;
                }
                return response;
            }
        };
    }
    @Override
    public String getFormal() {
        return UrlConfig.formal.getUrl();
    }

    @Override
    public String getTest() {
        return UrlConfig.test.getUrl();
    }
}
