package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class EditTextActivity extends AppCompatActivity {
    private EditText etUsername, etPassword, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etPhone = findViewById(R.id.et_phone);
        Button btnGetInput = findViewById(R.id.btn_get_input);

        // 点击按钮获取输入内容
        btnGetInput.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();  // 获取用户名（去空格）
            String password = etPassword.getText().toString();  // 获取密码
            String phone = etPhone.getText().toString();  // 获取手机号

            // 验证输入（非空判断）
            if (username.isEmpty()) {
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                return;
            }

            // 显示输入结果
            String result = "用户名：" + username + "\n密码：" + password + "\n手机号：" + phone;
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        });
    }
}
