package com.xiangxueketan.jetpack.lifecycle;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import com.xiangxueketan.R;
import com.xiangxueketan.jetpack.lifecycle.v1.CustomLifecycleObserver;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/21 上午9:59
 * @Version: 1.0
 */
public class LifeCycleActivity extends AppCompatActivity implements LifecycleObserver {
    private CustomLifecycleObserver customLifecycleObserver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        customLifecycleObserver = new CustomLifecycleObserver();
        getLifecycle().addObserver(customLifecycleObserver);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(customLifecycleObserver);
    }
}
