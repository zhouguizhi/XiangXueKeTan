package com.zgz.generic;
/**
 * @Description: 泛型接口
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午5:19
 * @Version: 1.0
 */
public interface GenericInterfaceTest<T> {
    //在接口定义泛型方法
    void setData(T t);
     T  getData(T t);
    //这不是在接口中定义泛型方法正确的样子
//     <T> T  getResult(T t);
}
