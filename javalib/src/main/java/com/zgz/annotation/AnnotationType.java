package com.zgz.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Description:注解演示
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 上午9:43
 * @Version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface AnnotationType {
    String result() default "zhouguizhi";
    int age();
}
