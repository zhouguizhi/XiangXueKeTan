package com.zgz.java8.lambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description: lambda练习
 * @Author: zhouguizhi
 * @CreateDate: 2021/2/7 下午3:01
 * @Version: 1.0
 */
public class TestLambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.forEach(integer -> System.out.println("hahhahah"+integer));
        createThread();
//        test1();
//        test2();
//        test3();
        System.out.println("value:="+test4(10, (x)->x*x));
        String str = test5("helloworld",(x)->x.toUpperCase());
        System.out.println("str:="+str);
//        String str1 = test5("helloworld",(x)->x.);
//        System.out.println("str1:="+str1);
    }
    public static void createThread(){
        Runnable runnable = ()->{
            System.out.println("hello lambda");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public static void test1(){
        Consumer<String> consumer = x->System.out.println("x="+x);
        consumer.accept("hello lambda");
    }
    public static void test2(){
        Comparator<Integer> comparator = (x,y)->{
            System.out.println("x:="+x);
            System.out.println("y:="+y);
            return Integer.compare(x,y);
        };
        comparator.compare(1,3);
    }
    public static void test3(){
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        comparator.compare(1,3);
    }
    public static Integer test4(Integer num,MyFun myFun){
        return myFun.getValue(num);
    }
    public static String test5(String str,MyFunction myFunction){
        return myFunction.getValue(str);
    }
}
