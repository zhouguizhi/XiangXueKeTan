package com.xiangxueketan.ioc.reflect;
import android.widget.TextView;
import com.xiangxueketan.R;
import com.xiangxueketan.base.BaseActivity;
import com.xiangxueketan.databinding.ActivityReflectWayImplIocBinding;
import com.xiangxueketan.ioc.reflect.annotation.BindView;
/**
 * @Description: 通过反射的方式实现ioc
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/29 上午9:56
 * @Version: 1.0
 */
public class ReflectWayImplIocActivity extends BaseActivity<ActivityReflectWayImplIocBinding> {
    @BindView(id = R.id.tv_content)
    TextView tvContent;
    @Override
    public int loadLayoutId() {
        return R.layout.activity_reflect_way_impl_ioc;
    }
    @Override
    public void init() {
        InjectUtils.injectView(this);
    }
}
