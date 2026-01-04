package com.example.androidviewcollection.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.androidviewcollection.R;
import com.example.androidviewcollection.adapter.ViewPagerAdapter;
import com.example.androidviewcollection.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = findViewById(R.id.view_pager);

        // 1. 准备页面数据（创建3个Fragment）
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(PageFragment.newInstance("页面1"));
        fragments.add(PageFragment.newInstance("页面2"));
        fragments.add(PageFragment.newInstance("页面3"));

        // 2. 设置适配器
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);
    }
}
