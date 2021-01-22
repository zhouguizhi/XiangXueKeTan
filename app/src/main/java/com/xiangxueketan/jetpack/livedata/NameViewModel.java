package com.xiangxueketan.jetpack.livedata;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
/**
 * @Description: 演示viewModel
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/22 上午10:24
 * @Version: 1.0
 */
public class NameViewModel extends ViewModel {
    private MutableLiveData<String> currentName;
    public MutableLiveData<String> getCurrentName(){
        if(null==currentName){
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }
}
