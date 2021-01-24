package com.xiangxueketan.mvvm.v1.bean;
import com.xiangxueketan.mvvm.v1.constant.RequestUrlConfig;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午5:44
 * @Version: 1.0
 */
public enum  UrlConfig {
    formal(RequestUrlConfig.FORMAT_URL),test(RequestUrlConfig.TEST_URL);
    private String mBaseUrl;
    private UrlConfig(String url){
        this.mBaseUrl = url;
    }

    public String getUrl() {
        return mBaseUrl;
    }
}
