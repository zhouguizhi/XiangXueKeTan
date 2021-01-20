package com.zgz.reflect;
/**
 * @Description: 反射测试类
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午3:03
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person(18,"zhouguizhi");
        Class<? extends Person> personClass = person.getClass();
        String name = personClass.getName();
        System.out.println("name:="+name);
        String simpleName = personClass.getSimpleName();
        System.out.println("simpleName:="+simpleName);
    }
}
