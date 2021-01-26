package com.xiangxueketan.mvvm.v1.fragment.model;
import com.xiangxueketan.mvvm.v1.api.NewsApiInterface;
import com.xiangxueketan.mvvm.v1.base.BaseCustomViewModel;
import com.xiangxueketan.mvvm.v1.base.mvvm.model.BaseMVVMModel;
import com.xiangxueketan.mvvm.v1.bean.NewsListBean;
import com.xiangxueketan.mvvm.v1.bean.PageResult;
import com.xiangxueketan.mvvm.v1.fragment.views.pictruetitleview.PictureViewModel;
import com.xiangxueketan.mvvm.v1.fragment.views.titleview.TitleViewModel;
import com.xiangxueketan.mvvm.v1.net.TecentNetworkApi;
import com.xiangxueketan.mvvm.v1.net.observer.BaseObserver;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/25 下午8:21
 * @Version: 1.0
 */
public class NewsListModel extends BaseMVVMModel {
    private final String channelId;
    private final String channelName;
    public NewsListModel(String channelId,String channelName) {
        super(true);
        this.channelId = channelId;
        this.channelName = channelName;
    }
    public void refreshData(){
        mPage = 1;
        loadData();
    }
    @Override
    public void loadData() {
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsList(channelId,channelName,String.valueOf(mPage))
                .compose(TecentNetworkApi.getInstance().applySchedulers(new BaseObserver<NewsListBean>() {
                    @Override
                    public void onSuccess(NewsListBean newsListBean) {
                        mPage++;
                        List<BaseCustomViewModel> viewModelList = new ArrayList<>();
                        for(NewsListBean.Contentlist contentlist:newsListBean.showapiResBody.pagebean.contentlist){
                            if(contentlist.imageurls!=null&&!contentlist.imageurls.isEmpty()){
                                PictureViewModel pictureViewModel = new PictureViewModel();
                                pictureViewModel.title = contentlist.title;
                                pictureViewModel.jumpUrl = contentlist.link;
                                pictureViewModel.pictureUrl = contentlist.imageurls.get(0).url;
                                viewModelList.add(pictureViewModel);
                            }else{
                                TitleViewModel titleViewModel = new TitleViewModel();
                                titleViewModel.title = contentlist.title;
                                titleViewModel.jumpUrl = contentlist.link;
                                viewModelList.add(titleViewModel);
                            }
                        }
                        if(null!=mWeakReference&&mWeakReference.get()!=null){
                            mWeakReference.get().onLoadSuccess(viewModelList,new PageResult(mPage==1,viewModelList.isEmpty(),viewModelList.size()>=10));
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
