package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class TextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        TextView tvBasic = findViewById(R.id.tv_basic);
        tvBasic.setText("代码修改后的文本");  // 动态改文本
        tvBasic.setTextColor(getResources().getColor(R.color.md3_error));  // 动态改颜色
        tvBasic.setTextSize(22);  // 动态改大小（单位默认 sp）
    }
}