package com.xiangxueketan.jetpack.livedata;
import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description: LiveData 维护 类似EventBus可以做到多个类之间数据交互
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/22 上午11:06
 * @Version: 1.0
 */
public class LiveDataBus {
    private Map<String, MutableLiveData<Object>> map;
    private static LiveDataBus liveDataBus = new LiveDataBus();
    private LiveDataBus(){
        map = new HashMap<>();
    }
    public static LiveDataBus getInstance(){
        return liveDataBus;
    }
    public synchronized <T> MutableLiveData<T> register(String key,Class<T> type){
        if(!map.containsKey(key)){
           map.put(key,new MutableLiveData<>());
        }
        return (MutableLiveData<T>) map.get(key);
    }
}
