package com.example.androidviewcollection.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidviewcollection.R;

// 通用页面Fragment，用于ViewPager展示
public class PageFragment extends Fragment {
    private static final String ARG_TEXT = "text"; // 传递文本的key

    // 创建Fragment实例并传递参数
    public static PageFragment newInstance(String text) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 加载Fragment布局
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView tvText = view.findViewById(R.id.tv_page_text);

        // 获取传递的文本并显示
        if (getArguments() != null) {
            String text = getArguments().getString(ARG_TEXT);
            tvText.setText(text);
        }
        return view;
    }
}