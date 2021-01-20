package com.zgz.reflect;
import com.zgz.annotation.AnnotationType;
/**
 * @Description: 男人
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午3:02
 * @Version: 1.0
 */
@AnnotationType(age = 19)
public class Man extends Person{
    private int age;
    private String name;

    public Man(int age) {
        this.age = age;
    }

    public Man(String name) {
        this.name = name;
    }

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
