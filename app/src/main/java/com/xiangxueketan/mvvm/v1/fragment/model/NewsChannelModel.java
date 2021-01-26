package com.xiangxueketan.mvvm.v1.fragment.model;
import androidx.annotation.NonNull;
import com.xiangxueketan.mvvm.v1.api.NewsApiInterface;
import com.xiangxueketan.mvvm.v1.base.mvvm.model.IBaseModelListener;
import com.xiangxueketan.mvvm.v1.bean.NewsChannelsBean;
import com.xiangxueketan.mvvm.v1.net.TecentNetworkApi;
import com.xiangxueketan.mvvm.v1.net.observer.BaseObserver;
import java.util.List;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/25 下午7:40
 * @Version: 1.0
 */
public class NewsChannelModel {
    private IBaseModelListener<List<NewsChannelsBean.ChannelList>> iBaseModelListener;
    public NewsChannelModel(@NonNull IBaseModelListener iBaseModelListener) {
        this.iBaseModelListener = iBaseModelListener;
        loadData();
    }
    private void loadData() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>() {
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {
                        if(null!=iBaseModelListener){
                            iBaseModelListener.onLoadSuccess(newsChannelsBean.showapiResBody.channelList);
                        }
                    }
                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                        if(null!=iBaseModelListener){
                            iBaseModelListener.onLoadFail(e);
                        }
                    }
                }));
    }
}
