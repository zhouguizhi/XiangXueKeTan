package com.zgz.generic;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 演示为什么要出现泛型
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午4:42
 * @Version: 1.0
 */
public class GenericTest1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("zhouguizhi");
        //遍历
        for(int i=0;i<list.size();i++){
            Integer integer = (Integer) list.get(i);
            System.out.println("integer="+integer);
        }
    }
}
