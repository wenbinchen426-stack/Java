package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidviewcollection.R;
import com.example.androidviewcollection.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = findViewById(R.id.recycler_view);

        // 1. 设置布局管理器（线性布局）
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 可选：设置为水平滚动
        // layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        // 2. 准备数据
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            data.add("RecyclerView 列表项 " + i);
        }

        // 3. 设置适配器
        mAdapter = new RecyclerAdapter(data);
        mRecyclerView.setAdapter(mAdapter);

        // 4. 设置Item点击事件
        mAdapter.setOnItemClickListener((position, text) -> {
            Toast.makeText(this, "点击了：" + text, Toast.LENGTH_SHORT).show();
        });
    }
}
