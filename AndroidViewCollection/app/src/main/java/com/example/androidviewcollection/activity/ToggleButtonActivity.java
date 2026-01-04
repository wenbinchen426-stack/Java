package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class ToggleButtonActivity extends AppCompatActivity {
    private ToggleButton mToggleButton;
    private TextView tvState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        mToggleButton = findViewById(R.id.toggle_button);
        tvState = findViewById(R.id.tv_toggle_state);

        // 监听开关状态变化
        mToggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                tvState.setText("当前状态：开启");
                // 开启时的逻辑（如启用功能）
            } else {
                tvState.setText("当前状态：关闭");
                // 关闭时的逻辑（如禁用功能）
            }
        });
    }
}
