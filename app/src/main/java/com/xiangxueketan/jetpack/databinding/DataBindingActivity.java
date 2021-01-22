package com.xiangxueketan.jetpack.databinding;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.xiangxueketan.R;
/**
 * @Description: Databinging学习
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/22 下午3:30
 * @Version: 1.0
 */
public class DataBindingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bind);
        ViewDataBinding viewDataBinding =  DataBindingUtil.setContentView(this,R.layout.activity_data_bind);
    }
}
