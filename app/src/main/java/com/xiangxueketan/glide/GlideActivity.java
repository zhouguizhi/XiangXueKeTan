package com.xiangxueketan.glide;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.xiangxueketan.R;
/**
 * @Description: glide框架入口
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/21 下午2:20
 * @Version: 1.0
 */
public class GlideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ImageView ivImg = findViewById(R.id.iv_img);
        Glide.with(this).load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2496543145,3939945148&fm=26&gp=0.jpg").into(ivImg);
    }
}
