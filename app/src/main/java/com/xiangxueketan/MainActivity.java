package com.xiangxueketan;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.xiangxueketan.ioc.IOCActivity;
import com.xiangxueketan.jetpack.databinding.DataBindingActivity;
import com.xiangxueketan.glide.GlideActivity;
import com.xiangxueketan.hook.HookActivity;
import com.xiangxueketan.jetpack.lifecycle.LifeCycleActivity;
import com.xiangxueketan.jetpack.livedata.LiveDataActivity;
import com.xiangxueketan.jetpack.livedata.LiveDataBus;
import com.xiangxueketan.mvvm.v1.ui.MVVMActivity;
import com.xiangxueketan.skin.SkinActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        TextView textView = new TextView(this);
        textView.setOnClickListener(v -> {
            Log.e("zhouguizhi","xx");
            Log.e("zhouguizhi","xx");
        });
        //lambda表达式的写法
        textView.setOnClickListener(v-> {
            Log.e("zhouguizhi","xx");
        });
        textView.setText("我是新添加的");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        textView.setBackgroundColor(Color.BLUE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 300);
        layoutParams.topMargin = 100;
        textView.setLayoutParams(layoutParams);
//        frameLayout.addView(textView);
    }
    public void checkPermission(){
        XXPermissions.with(this)
                //WRITE_SETTINGS WRITE_EXTERNAL_STORAGE
//                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .permission(Permission.MANAGE_EXTERNAL_STORAGE)
//                .permission(Permission.READ_EXTERNAL_STORAGE)
//                .permission(Permission.WRITE_SETTINGS)
                .request(new OnPermissionCallback() {
                    @Override
                    public void onGranted(List<String> permissions, boolean all) {

                    }
                    @Override
                    public void onDenied(List<String> permissions, boolean never) {

                    }
       });
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
        //从这验证LiveData有粘性事件,点击的时候LiveDataActivity都还没创建,但是在LiveDataActivity监听确实得到了发送的数据
        startActivity(new Intent(this, LiveDataActivity.class));
        LiveDataBus.getInstance().register("data",String.class).postValue("我是在MainActivity发送的数据");
    }

    public void onDataBindingClickListener(View view) {
        startActivity(new Intent(this, DataBindingActivity.class));

    }

    public void onMvvmClickListener(View view) {
        startActivity(new Intent(this, MVVMActivity.class));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == XXPermissions.REQUEST_CODE) {
            if (XXPermissions.isGrantedPermission(this, Permission.RECORD_AUDIO) &&
                    XXPermissions.isGrantedPermission(this, Permission.Group.CALENDAR)) {
//                toast("用户已经在权限设置页授予了录音和日历权限");
            } else {
//                toast("用户没有在权限设置页授予权限");
            }
        }
    }

    public void onSkinClickListener(View view) {
        startActivity(new Intent(this, SkinActivity.class));
    }

    public void onIocClickListener(View view) {
        startActivity(new Intent(this, IOCActivity.class));
    }
}