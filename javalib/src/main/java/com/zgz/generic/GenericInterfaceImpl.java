package com.zgz.generic;
/**
 * @Description: 泛型接口
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/19 下午5:25
 * @Version: 1.0
 */
public class GenericInterfaceImpl<Integer> implements GenericInterfaceTest<Integer>{
    private Integer age;
    @Override
    public void setData(Integer integer) {
        this.age = integer;
    }
    @Override
    public Integer getData(Integer integer) {
        return integer;
    }
}
