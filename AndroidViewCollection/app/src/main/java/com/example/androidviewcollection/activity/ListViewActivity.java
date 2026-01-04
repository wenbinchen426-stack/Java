package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;
import com.example.androidviewcollection.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView mListView; // 声明变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view); // 加载布局

        // 关键修复：通过 findViewById 绑定布局中的 ListView
        mListView = findViewById(R.id.list_view);

        // 1. 准备数据
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            data.add("列表项 " + i);
        }

        // 2. 设置适配器（此时 mListView 已初始化，无空指针）
        ListViewAdapter adapter = new ListViewAdapter(this, data);
        mListView.setAdapter(adapter);

        // 3. 列表项点击事件
        mListView.setOnItemClickListener((parent, view, position, id) -> {
            String itemText = data.get(position);
            Toast.makeText(this, "点击了：" + itemText, Toast.LENGTH_SHORT).show();
        });
    }
}