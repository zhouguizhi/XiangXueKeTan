package com.xiangxueketan.hook;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
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
    private TextView tvHook;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook);
        tvHook = findViewById(R.id.tv_hook);
        //
        tvHook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zhouguizhi","点击了textview");
            }
        });
        HookSetOnClickListenerHelper.hook(this,tvHook);
    }
}
