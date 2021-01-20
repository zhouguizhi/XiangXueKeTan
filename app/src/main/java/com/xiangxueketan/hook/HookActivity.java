package com.xiangxueketan.hook;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.xiangxueketan.R;
/**
 * @Description: hook练习
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午5:49
 * @Version: 1.0
 */
public class HookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook);
    }
}
