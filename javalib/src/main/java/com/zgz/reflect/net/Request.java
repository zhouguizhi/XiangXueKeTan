package com.zgz.reflect.net;
import com.zgz.reflect.bean.OrderBean;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * @Description: 假装请求类的封装
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午4:17
 * @Version: 1.0
 */
public class Request {
    private Request() {
    }
    /**
     *模拟Callback是接口如何获取接口上泛型的具体类型
     * @param callback
     * @param <T>
     */
    public static <T> void login(String name, ICallback<T> callback) {
        Type[] types = callback.getClass().getGenericInterfaces();
        ParameterizedType parameterized = (ParameterizedType) types[0];
        Class<T> clazz = (Class<T>) parameterized.getActualTypeArguments()[0];
        //模拟出json数据
        OrderBean orderBean = new OrderBean();
        orderBean.setId("123456789");
        orderBean.setName("秀友商场");
        String json = GsonUtil.gsonString(orderBean);
        T t = GsonUtil.gsonToBean(json, clazz);
        callback.onSuccess(t);
    }
    /**
     * 模拟Callback是普通类如何获取类上泛型的具体类型
     * @param callback
     * @param <T>
     */
    public static <T> void login(String name, Callback<T> callback) {
        Class<T> tClass = (Class<T>) ((ParameterizedType) callback.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        //模拟出json数据
        OrderBean orderBean = new OrderBean();
        orderBean.setId("123456789");
        orderBean.setName("秀友商场");
        String json = GsonUtil.gsonString(orderBean);
        T t = GsonUtil.gsonToBean(json, tClass);
        callback.onSuccess(t);
    }
}
