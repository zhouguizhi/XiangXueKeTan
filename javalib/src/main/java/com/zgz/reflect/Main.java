package com.zgz.reflect;
import com.zgz.reflect.bean.OrderBean;
import com.zgz.reflect.net.Callback;
import com.zgz.reflect.net.ICallback;
import com.zgz.reflect.net.Request;
import java.lang.reflect.Field;
/**
 * @Description: 反射测试类
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/20 下午3:03
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Man person = new Man(18,"zhouguizhi");
        Class<? extends Man> personClass = person.getClass();
//        String name = personClass.getName();
//        System.out.println("name:="+name);
//        String simpleName = personClass.getSimpleName();
//        System.out.println("simpleName:="+simpleName);
//        Package aPackage = personClass.getPackage();
//        System.out.println("获取包名:="+aPackage.getName());
          //获取所有定义的属性,不包含父类
//        Field[] fields = personClass.getDeclaredFields();
//        for(Field field:fields){
//            System.out.println("属性名:="+field.getName());
//        }
//        System.out.println("-----------------");
          //获取所有public定义修饰的属性, 包含父类
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println("属性名:="+field.getName());
        }
        //获取父类的Class对象
//        Class<?> superclass = personClass.getSuperclass();
//        System.out.println("父类名:="+superclass.getName());
//        personClass.getGenericSuperclass();
//        try {
//            Field fieldAge = personClass.getDeclaredField("age");
//            fieldAge.setAccessible(true);
//            System.out.println("获取年龄属性:="+fieldAge.getInt(person));
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Field fieldSex = null;
//        try {
//            fieldSex= personClass.getField("sex");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        System.out.println("获取性别属性:="+fieldSex.getInt(person));
//        Annotation[] annotations = personClass.getAnnotations();
//        System.out.println("获取类上的注解:="+annotations.length);
//        Annotation annotation = personClass.getAnnotation(AnnotationType.class);
//        System.out.println("annotation:="+annotation);

        //获取所有的构造函数
//        Constructor<?>[] constructors = personClass.getConstructors();
//        for(Constructor constructor:constructors){
//            System.out.println("获取构造函数:="+constructor.getName());
//        }
        //
//        try {
//            //获取某一个构造函数,通过传递参数类型
//            Constructor<? extends Man> constructor = personClass.getConstructor(int.class);
//            System.out.println("获取构造函数:="+constructor.getName());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        Method[] declaredMethods = personClass.getDeclaredMethods();
//        for(Method method:declaredMethods){
//            System.out.println("获取方法名:="+method.getName());
//        }

        //获取所有定义的方法,包含父类的以及Object类中定义的方法
//        Method[] declaredMethods = personClass.getMethods();
//        for(Method method:declaredMethods){
//            System.out.println("获取方法名:="+method.getName());
//        }
        //模拟网络请求,获取到数据后 返回给上层的实体bean对象
        Request.login("zhouguizhi", new Callback<OrderBean>() {
            @Override
            public void onSuccess(OrderBean o) {
                System.out.println("请求成功后的数据:="+o);
            }
            @Override
            public void onFail() {

            }
        });
        //这个ICallback是接口
        Request.login("zhouguizhi", new ICallback<OrderBean>() {
            @Override
            public void onSuccess(OrderBean orderBean) {
                System.out.println("orderBean:="+orderBean);
            }
        });
    }
}
