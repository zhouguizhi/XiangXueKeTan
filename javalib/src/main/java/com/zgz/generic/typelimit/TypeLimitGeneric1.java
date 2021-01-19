package com.zgz.generic.typelimit;
/**
 * @Description: 演示泛型的
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午9:52
 * @Version: 1.0
 */
public class TypeLimitGeneric1<T> {

    public static void main(String[] args) {
//        TypeLimitGeneric1<String>[] arr;//定义带泛型的数组是可以的
//        arr = new TypeLimitGeneric1<String>[10];//创建数组就会被报错
        TypeLimitGeneric1<String> generic1 = new TypeLimitGeneric1();
        System.out.println(generic1.getResult(3,5));
    }
    /**
     * 返回比较中大的值
     * @return
     */
    public <T extends Comparable> T getResult(T a, T b){
        return a.compareTo(b)>0?a:b;
    }
    public static <T> T returnResult(T t){
        return t;
    }
}
