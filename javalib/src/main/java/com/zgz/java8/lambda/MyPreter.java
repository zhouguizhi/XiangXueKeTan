package com.zgz.java8.lambda;

/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/2/7 下午5:09
 * @Version: 1.0
 */
@FunctionalInterface
public interface MyPreter<T>{
    void accept(T t);
}
