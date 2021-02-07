package com.zgz.java8.lambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
/**
 * @Description: lambda练习
 * @Author: zhouguizhi
 * @CreateDate: 2021/2/7 下午3:01
 * @Version: 1.0
 */
public class TestLambda {
    public static void main(String[] args) {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(t1,t2);
            }
        };
        TreeSet treeSet = new TreeSet<>(com);
        //使用lambda表达式写法 注意你配置的jdk版本要是大于或者等于jdk8
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.forEach(integer -> System.out.println("hahhahah"+integer));
    }
}
