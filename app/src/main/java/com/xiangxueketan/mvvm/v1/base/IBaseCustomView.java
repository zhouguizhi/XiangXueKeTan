package com.xiangxueketan.mvvm.v1.base;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/25 上午10:02
 * @Version: 1.0
 */
public interface IBaseCustomView<D extends BaseCustomViewModel> {
    void setData(D d);
}
