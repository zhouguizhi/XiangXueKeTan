package com.xiangxueketan.hook;
import android.util.Log;
import com.xiangxueketan.R;
import com.xiangxueketan.base.BaseActivity;
import com.xiangxueketan.databinding.ActivityHookBinding;
/**
 * @Description: hook练习
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午5:49
 * @Version: 1.0
 */
public class HookActivity extends BaseActivity<ActivityHookBinding> {
    @Override
    public int loadLayoutId() {
        return R.layout.activity_hook;
    }
    @Override
    public void init() {
        mBinding.tvHook.setOnClickListener(v -> Log.e("zhouguizhi","点击了textview"));
        HookSetOnClickListenerHelper.hook(this,mBinding.tvHook);
    }
}
