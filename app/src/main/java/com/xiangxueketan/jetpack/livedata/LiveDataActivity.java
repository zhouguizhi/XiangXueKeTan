package com.xiangxueketan.jetpack.livedata;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.xiangxueketan.R;
/**
 * @Description: 演示LiveData
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/21 下午11:08
 * @Version: 1.0
 */
public class LiveDataActivity extends AppCompatActivity {
    private NameViewModel nameViewModel;
    private TextView tvMsg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        tvMsg = findViewById(R.id.tv_msg);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new NameViewModelFactory());
        nameViewModel = viewModelProvider.get(NameViewModel.class);
        //观察者观察数据
        nameViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvMsg.setText(s);
            }
        });
        tvMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changText();
            }
        });
        LiveDataBus.getInstance().register("data",String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("zhouguizhi","s:>>>>"+s);
            }
        });
    }
    public void changText(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                LiveDataBus.getInstance().register("data",String.class).postValue("jsjsjjsjsjsjs");
                nameViewModel.getCurrentName().postValue("我是在子线程中更新的");
            }
        }.start();
    }
    public class NameViewModelFactory implements ViewModelProvider.Factory {
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            try {
                return modelClass.newInstance(); //使用newInstance反射实例ViewModel，并且传出去
            } catch (IllegalAccessException | java.lang.InstantiationException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
