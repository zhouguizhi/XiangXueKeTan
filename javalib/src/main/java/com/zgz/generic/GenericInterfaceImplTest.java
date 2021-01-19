package com.zgz.generic;
/**
 * @Description: 测试泛型接口
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午8:44
 * @Version: 1.0
 */
public class GenericInterfaceImplTest {
    public static void main(String[] args) {
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.setData(100);
        System.out.println(genericInterface.getData(100));
    }
}
