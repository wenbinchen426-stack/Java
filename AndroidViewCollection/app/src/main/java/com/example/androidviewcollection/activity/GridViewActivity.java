package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;
import com.example.androidviewcollection.adapter.GridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    private GridView mGridView; // 声明但未初始化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // 关键修复：通过 findViewById 绑定布局中的 GridView
        mGridView = findViewById(R.id.grid_view);

        // 1. 准备数据
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            data.add("网格项 " + i);
        }

        // 2. 设置适配器（此时 mGridView 已初始化，不会空指针）
        GridViewAdapter adapter = new GridViewAdapter(this, data);
        mGridView.setAdapter(adapter);

        // 3. 网格项点击事件
        mGridView.setOnItemClickListener((parent, view, position, id) -> {
            String itemText = data.get(position);
            Toast.makeText(GridViewActivity.this, "点击了：" + itemText, Toast.LENGTH_SHORT).show();
        });
    }
}