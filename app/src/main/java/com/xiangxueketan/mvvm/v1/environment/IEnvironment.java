package com.xiangxueketan.mvvm.v1.environment;
/**
 * @Description: 网络请求是正式还是测试
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/23 下午6:42
 * @Version: 1.0
 */
public interface IEnvironment {
    String getFormal();
    String getTest();
}
