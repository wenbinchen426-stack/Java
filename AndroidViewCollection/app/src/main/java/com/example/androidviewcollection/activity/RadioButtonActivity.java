package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        rgGender = findViewById(R.id.rg_gender);
        Button btnGetRadio = findViewById(R.id.btn_get_radio);
        // 方式1：点击按钮获取选择结果
        btnGetRadio.setOnClickListener(v -> getSelectedGender());
        // 方式2：监听选择变化（实时获取）
        rgGender.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRb = findViewById(checkedId);
            Toast.makeText(RadioButtonActivity.this,
                    "实时选择：" + selectedRb.getText(),
                    Toast.LENGTH_SHORT).show();
        });
    }
    // 获取选中的性别
    private void getSelectedGender() {
        int checkedId = rgGender.getCheckedRadioButtonId();  // 获取选中按钮的ID
        if (checkedId == -1) { // 未选择
            Toast.makeText(this, "请选择性别", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedRb = findViewById(checkedId);
        Toast.makeText(this, "你选择了：" + selectedRb.getText(), Toast.LENGTH_SHORT).show();
    }
}
