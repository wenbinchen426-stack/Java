package com.example.androidviewcollection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidviewcollection.R;

import java.util.List;

// 泛型指定数据类型（这里是String）
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<String> mData;  // 数据源
    private OnItemClickListener mListener;  // 点击监听器

    // 构造方法：传入数据
    public RecyclerAdapter(List<String> data) {
        mData = data;
    }

    // 创建ViewHolder（加载Item布局）
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    // 绑定数据到ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.tvText.setText(text);

        // 绑定点击事件
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(position, text);
            }
        });
    }

    // 获取数据数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // ViewHolder：缓存Item视图
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_item_text);
        }
    }

    // 点击事件接口
    public interface OnItemClickListener {
        void onItemClick(int position, String text);
    }

    // 设置点击监听器
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}