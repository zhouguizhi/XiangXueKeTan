package com.xiangxueketan.ioc;
import android.content.Intent;
import com.xiangxueketan.R;
import com.xiangxueketan.base.BaseActivity;
import com.xiangxueketan.databinding.ActivityIocBinding;
import com.xiangxueketan.ioc.reflect.ReflectWayImplIocActivity;
/**
 * @Description: ioc学习
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/29 上午9:42
 * @Version: 1.0
 */
public class IOCActivity extends BaseActivity<ActivityIocBinding> {
    @Override
    public int loadLayoutId() {
        return R.layout.activity_ioc;
    }
    @Override
    public void init() {
        startActivity(new Intent(this, ReflectWayImplIocActivity.class));
    }
}
