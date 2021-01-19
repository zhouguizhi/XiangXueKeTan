package com.zgz.generic;
/**
 * @Description: 泛型类
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午5:19
 * @Version: 1.0
 */
public class GenericClassTest<Double> extends SuperGenericClassTest<String>{

    public static void main(String[] args) {
        GenericClassTest<String> genericClassTest = new GenericClassTest();
        genericClassTest.setT("zhouguizhi");
        System.out.println(genericClassTest.getT());
    }
}
