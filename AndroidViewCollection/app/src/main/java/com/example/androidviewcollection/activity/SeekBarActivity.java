package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class SeekBarActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    private TextView tvProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        // 初始化控件
        mSeekBar = findViewById(R.id.seek_bar);
        tvProgress = findViewById(R.id.tv_progress);

        // 监听进度变化
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // 进度改变时回调
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 更新文本显示当前进度
                tvProgress.setText("当前进度：" + progress);
            }

            // 开始触摸时回调
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            // 停止触摸时回调
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
