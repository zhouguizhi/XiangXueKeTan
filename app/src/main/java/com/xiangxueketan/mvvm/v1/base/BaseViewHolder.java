package com.xiangxueketan.mvvm.v1.base;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/**
 * @Description: ViewHolder
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午11:07
 * @Version: 1.0
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private IBaseCustomView itemView;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = (IBaseCustomView) itemView;
    }
    public void bind(BaseCustomViewModel viewModel) {
        itemView.setData(viewModel);
    }
}
