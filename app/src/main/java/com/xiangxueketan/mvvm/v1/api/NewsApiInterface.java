package com.xiangxueketan.mvvm.v1.api;
import com.xiangxueketan.mvvm.v1.bean.NewsChannelsBean;
import com.xiangxueketan.mvvm.v1.bean.NewsListBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:55
 * @Version: 1.0
 */
public interface NewsApiInterface {
    @GET("release/news")
    Observable<NewsListBean> getNewsList(@Query("channelId") String channelId,
                                         @Query("channelName") String channelName,
                                         @Query("page") String page);

    @GET("release/channel")
    Observable<NewsChannelsBean> getNewsChannels();
}
