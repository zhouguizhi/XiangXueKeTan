package com.zgz.java8;
import java.util.function.Consumer;
/**
 * @Description: Consumer 测试
 * @Author: zhouguizhi
 * @CreateDate: 2021/2/18 上午10:40
 * @Version: 1.0
 */
public class TestConsumer {
    public static void main(String[] args) {
        happy(1000, aDouble -> {
            double v = aDouble * 0.8;
            System.out.println(v);
        });
    }
    public static void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }
}
