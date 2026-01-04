package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class ProgressBarActivity extends AppCompatActivity {
    private ProgressBar mHorizontalProgress;
    private int currentProgress = 30;  // 当前进度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        mHorizontalProgress = findViewById(R.id.progress_horizontal);
        Button btnUpdate = findViewById(R.id.btn_update_progress);

        // 点击按钮更新进度
        btnUpdate.setOnClickListener(v -> {
            currentProgress += 10;
            if (currentProgress > 100) {
                currentProgress = 0;  // 重置
            }
            mHorizontalProgress.setProgress(currentProgress);  // 更新进度
        });

        // 模拟加载任务（自动更新进度）
        simulateLoading();
    }

    // 模拟加载任务（5秒内完成）
    private void simulateLoading() {
        Handler handler = new Handler(Looper.getMainLooper());
        for (int i = 0; i <= 100; i++) {
            final int progress = i;
            handler.postDelayed(() -> {
                mHorizontalProgress.setProgress(progress);
            }, i * 50);  // 每50ms更新一次
        }
    }
}
