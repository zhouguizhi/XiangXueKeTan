package com.xiangxueketan.mvvm.v1.fragment.views.pictruetitleview;
import android.content.Context;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.PictureTitleViewBinding;
import com.xiangxueketan.mvvm.v1.base.BaseCustomView;
import com.xiangxueketan.mvvm.v1.base.BaseView;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午11:33
 * @Version: 1.0
 */
public class PictureView extends BaseView<PictureTitleViewBinding> implements BaseCustomView<PictureViewModel> {
    private PictureViewModel mPictureViewModel;
    public PictureView(Context context) {
        super(context);
    }
    @Override
    public void init() {
    }
    @Override
    public int layoutId() {
        return R.layout.picture_title_view;
    }
    @Override
    public void setData(PictureViewModel pictureViewModel) {
        mBinding.setViewmodel(pictureViewModel);
        //更新view
        mBinding.executePendingBindings();
        this.mPictureViewModel = pictureViewModel;
    }
}
