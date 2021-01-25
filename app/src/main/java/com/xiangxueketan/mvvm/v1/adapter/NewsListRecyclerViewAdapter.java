package com.xiangxueketan.mvvm.v1.adapter;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.xiangxueketan.mvvm.v1.base.BaseCustomViewModel;
import com.xiangxueketan.mvvm.v1.base.BaseViewHolder;
import com.xiangxueketan.mvvm.v1.fragment.views.pictruetitleview.PictureView;
import com.xiangxueketan.mvvm.v1.fragment.views.pictruetitleview.PictureViewModel;
import com.xiangxueketan.mvvm.v1.fragment.views.titleview.TitleView;
import java.util.List;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/24 下午9:27
 * @Version: 1.0
 */
public class NewsListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final int VIEW_TYPE_PICTURE_TITLE = 1;
    private final int VIEW_TYPE_TITLE = 2;
    private List<BaseCustomViewModel> mItems;

    public void setData(List<BaseCustomViewModel> items) {
        mItems = items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return null!=mItems?mItems.size():0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems != null && mItems.get(position) instanceof PictureViewModel) {
            return VIEW_TYPE_PICTURE_TITLE;
        }
        return VIEW_TYPE_TITLE;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_PICTURE_TITLE) {
            return new BaseViewHolder(new PictureView(parent.getContext()));
        } else if (viewType == VIEW_TYPE_TITLE) {
            return new BaseViewHolder(new TitleView(parent.getContext())) ;
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }
}
