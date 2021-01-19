package com.zgz.generic;

/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午8:47
 * @Version: 1.0
 */
public class SuperGenericClassTest<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    public int addInt(int x,int y){
        return x+y;
    }
    public float addFloat(float x,float y){
        return x+y;
    }
//    public <T extends Number> T add(T t1,T t2){
//        return t1 + t2;
//    }
}
