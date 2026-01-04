package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class ImageViewActivity extends AppCompatActivity {
    private boolean isEnlarged = false;  // 标记图片是否放大
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ImageView ivDrawable = findViewById(R.id.iv_drawable);
        // 点击图片切换放大/缩小
        ivDrawable.setOnClickListener(v -> {
            if (isEnlarged) {
                // 缩小：恢复原尺寸
                ivDrawable.setMaxWidth(300);
                ivDrawable.setMaxHeight(300);
            } else {
                // 放大：设置更大尺寸
                ivDrawable.setMaxWidth(500);
                ivDrawable.setMaxHeight(500);
            }
            isEnlarged = !isEnlarged;  // 切换状态
        });
    }
}
