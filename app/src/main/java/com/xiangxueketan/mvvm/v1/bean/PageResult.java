package com.xiangxueketan.mvvm.v1.bean;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/26 上午11:45
 * @Version: 1.0
 */
public class PageResult {
    private boolean isFirstPage;
    private boolean isEmpty;
    private boolean isHasNextPage;

    public PageResult(boolean isFirstPage, boolean isEmpty, boolean isHasNextPage) {
        this.isFirstPage = isFirstPage;
        this.isEmpty = isEmpty;
        this.isHasNextPage = isHasNextPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isHasNextPage() {
        return isHasNextPage;
    }
}
