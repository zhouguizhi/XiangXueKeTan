package com.xiangxueketan;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.xiangxueketan.glide.GlideActivity;
import com.xiangxueketan.hook.HookActivity;
import com.xiangxueketan.jetpack.lifecycle.LifeCycleActivity;
import com.xiangxueketan.jetpack.livedata.LiveDataActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHookClickListener(View view) {
        startActivity(new Intent(this, HookActivity.class));
    }
    public void onLifeCycleClickListener(View view) {
        startActivity(new Intent(this, LifeCycleActivity.class));
    }

    public void onGlideClickListener(View view) {
        startActivity(new Intent(this, GlideActivity.class));
    }

    public void onLiveDataClickListener(View view) {
        startActivity(new Intent(this, LiveDataActivity.class));
    }
}