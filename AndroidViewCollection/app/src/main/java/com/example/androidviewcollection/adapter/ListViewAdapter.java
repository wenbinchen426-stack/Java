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

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;

    public ListViewAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 复用View（优化滑动性能）
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder();
            holder.ivItem = convertView.findViewById(R.id.iv_list_item);
            holder.tvItem = convertView.findViewById(R.id.tv_list_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置数据
        holder.tvItem.setText(mData.get(position));
        return convertView;
    }

    static class ViewHolder {
        ImageView ivItem;
        TextView tvItem;
    }
}