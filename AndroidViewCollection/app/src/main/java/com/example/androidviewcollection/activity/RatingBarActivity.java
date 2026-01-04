package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class RatingBarActivity extends AppCompatActivity {
    private RatingBar mRatingBar;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        mRatingBar = findViewById(R.id.rating_bar);
        tvResult = findViewById(R.id.tv_rating_result);

        // 监听评分变化
        mRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            // 更新显示当前评分
            tvResult.setText("当前评分：" + rating);
        });
    }
}
