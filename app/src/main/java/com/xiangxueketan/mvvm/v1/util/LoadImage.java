package com.xiangxueketan.mvvm.v1.util;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午11:48
 * @Version: 1.0
 */
public class LoadImage {
    @BindingAdapter("loadImageUrl")
    public static void loadImageUrl(ImageView imageView,String pictureUrl){
        Glide.with(imageView.getContext())
                .load(pictureUrl)
                .into(imageView);
    }
}
