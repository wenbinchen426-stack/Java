package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox cbApple, cbBanana, cbOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cbApple = findViewById(R.id.cb_apple);
        cbBanana = findViewById(R.id.cb_banana);
        cbOrange = findViewById(R.id.cb_orange);
        Button btnGetCheck = findViewById(R.id.btn_get_check);

        // 点击按钮获取选择结果
        btnGetCheck.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder("你选择了：");

            // 判断每个复选框是否被选中
            if (cbApple.isChecked()) {
                result.append("苹果、");
            }
            if (cbBanana.isChecked()) {
                result.append("香蕉、");
            }
            if (cbOrange.isChecked()) {
                result.append("橙子、");
            }

            // 处理无选择的情况
            if (result.length() == 4) { // 初始字符串"你选择了："长度为4
                result.append("无");
            } else {
                // 去除最后一个"、"
                result.deleteCharAt(result.length() - 1);
            }

            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}

