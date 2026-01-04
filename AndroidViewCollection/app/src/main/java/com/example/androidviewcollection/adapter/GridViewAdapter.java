package com.example.androidviewcollection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidviewcollection.R;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData; // 数据源（文本）

    public GridViewAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size(); // 数据总数
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position); // 获取对应位置数据
    }

    @Override
    public long getItemId(int position) {
        return position; // 位置ID
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 复用View（优化性能）
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_grid, parent, false);
            holder = new ViewHolder();
            holder.ivItem = convertView.findViewById(R.id.iv_grid_item);
            holder.tvItem = convertView.findViewById(R.id.tv_grid_item);
            convertView.setTag(holder); // 存储ViewHolder
        } else {
            holder = (ViewHolder) convertView.getTag(); // 复用ViewHolder
        }

        // 设置数据
        String text = mData.get(position);
        holder.tvItem.setText(text);
        // 可根据position设置不同图片（示例用默认图标）
        holder.ivItem.setImageResource(R.drawable.tu);

        return convertView;
    }

    // ViewHolder：缓存子项视图
    static class ViewHolder {
        ImageView ivItem;
        TextView tvItem;
    }
}