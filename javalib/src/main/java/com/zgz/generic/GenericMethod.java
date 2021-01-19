package com.zgz.generic;
/**
 * @Description: 泛型方法
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午5:19
 * @Version: 1.0
 */
public class GenericMethod{
    public <T> T getData(T...a){
        return a[a.length/2];
    }
    /**
     * 定义泛型方法
     */
    public <K> K setKey(K t){
        return t;
    }
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        System.out.println(genericMethod.getData(1,2,3,4));
        genericMethod.setKey("zhouguihzi");
    }
}
