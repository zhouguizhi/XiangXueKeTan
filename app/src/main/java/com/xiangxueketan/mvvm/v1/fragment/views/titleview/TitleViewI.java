package com.xiangxueketan.mvvm.v1.fragment.views.titleview;
import android.content.Context;
import com.xiangxueketan.R;
import com.xiangxueketan.databinding.TitleViewBinding;
import com.xiangxueketan.mvvm.v1.base.IBaseCustomView;
import com.xiangxueketan.mvvm.v1.base.BaseView;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午10:05
 * @Version: 1.0
 */
public class TitleViewI extends BaseView<TitleViewBinding> implements IBaseCustomView<TitleViewModel> {
    private TitleViewModel mTitleViewModel;
    public TitleViewI(Context context) {
        super(context);
    }
    @Override
    public void init() {
    }
    @Override
    public int layoutId() {
        return R.layout.title_view;
    }
    @Override
    public void setData(TitleViewModel titleViewModel) {
        mBinding.setViewmodel(titleViewModel);
        //更新view
        mBinding.executePendingBindings();
        this.mTitleViewModel = titleViewModel;
    }
}
