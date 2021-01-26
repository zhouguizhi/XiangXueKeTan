package com.xiangxueketan.mvvm.v1.fragment.model;
import com.xiangxueketan.mvvm.v1.api.NewsApiInterface;
import com.xiangxueketan.mvvm.v1.base.mvvm.model.BaseMVVMModel;
import com.xiangxueketan.mvvm.v1.bean.NewsChannelsBean;
import com.xiangxueketan.mvvm.v1.net.TecentNetworkApi;
import com.xiangxueketan.mvvm.v1.net.observer.BaseObserver;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/25 下午7:40
 * @Version: 1.0
 */
public class NewsChannelModel extends BaseMVVMModel {
    public NewsChannelModel(boolean isNeedPage) {
        super(isNeedPage);
    }
    @Override
    public void loadData() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>() {
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {
                        if(null!=mWeakReference&&mWeakReference.get()!=null){
                            mWeakReference.get().onLoadSuccess(newsChannelsBean.showapiResBody.channelList);
                        }
                    }
                    @Override
                    public void onFailure(Throwable e) {
                        e.printStackTrace();
                        if(null!=mWeakReference&&mWeakReference.get()!=null){
                                mWeakReference.get().onLoadFail(e);
                        }
                    }
                }));
    }
}
