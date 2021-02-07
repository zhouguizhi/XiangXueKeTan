package com.xiangxueketan.ioc.reflect;
import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Field;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/29 上午10:17
 * @Version: 1.0
 */
public class InjectUtils {
    public static void injectView(Activity activity) {
        if(null==activity){
            return;
        }
        Class<? extends Activity> aClass = activity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Log.e("zhouguizhi","len="+fields.length);
        for(Field field:fields){
            Log.e("zhouguizhi","name="+field.getName());
        }
    }
}
