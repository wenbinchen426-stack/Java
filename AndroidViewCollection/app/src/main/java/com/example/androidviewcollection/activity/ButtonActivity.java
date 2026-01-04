package com.example.androidviewcollection.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button btnBasic = findViewById(R.id.btn_basic);
        btnBasic.setOnClickListener(this);

        // 绑定点击事件（方式2：匿名内部类）
        Button btnRound = findViewById(R.id.btn_round);
        btnRound.setOnClickListener(v -> {
        Toast.makeText(ButtonActivity.this, "圆角按钮被点击", Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_basic) {
            Toast.makeText(this, "基础按钮被点击", Toast.LENGTH_SHORT).show();
        }
    }
}
