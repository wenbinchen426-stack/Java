package com.example.androidviewcollection.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidviewcollection.R;
import com.example.androidviewcollection.fragment.FirstFragment;
import com.example.androidviewcollection.fragment.SecondFragment;

public class FrameLayoutActivity extends AppCompatActivity {
    // 状态标记：true表示当前显示SecondFragment（第一个Fragment），false表示显示FirstFragment
    private boolean isSecondFragment = true;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        // 初始化Fragment实例，避免重复创建
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        // 初始显示SecondFragment（作为第一个Fragment）
        showSecondFragment(false);

        Button btnSwitch = findViewById(R.id.btn_switch);
        btnSwitch.setOnClickListener(v -> switchFragment());
    }

    // 切换Fragment
    private void switchFragment() {
        if (isSecondFragment) {
            showFirstFragment();
        } else {
            showSecondFragment(true);
        }
        isSecondFragment = !isSecondFragment;
    }

    // 显示FirstFragment
    private void showFirstFragment() {
        FragmentManager fm = getSupportFragmentManager();
        // 清除可能存在的返回栈，确保不会累积
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, firstFragment);
        transaction.addToBackStack(null); // 加入返回栈，以便能回到SecondFragment
        transaction.commit();
    }

    // 显示SecondFragment
    private void showSecondFragment(boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, secondFragment);

        // 只有从FirstFragment切换回来时才加入返回栈
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();

        // 如果当前是SecondFragment（第一个Fragment），直接退出
        if (isSecondFragment) {
            finish();
        }
        // 如果当前是FirstFragment且有返回栈，返回SecondFragment
        else if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            isSecondFragment = true; // 更新状态标记
        }
        // 其他情况按默认处理
        else {
            super.onBackPressed();
        }
    }
}
