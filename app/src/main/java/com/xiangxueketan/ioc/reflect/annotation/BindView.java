package com.xiangxueketan.ioc.reflect.annotation;
import androidx.annotation.IdRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Description: 绑定view的注解
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/29 上午10:13
 * @Version: 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    @IdRes int id();
}
