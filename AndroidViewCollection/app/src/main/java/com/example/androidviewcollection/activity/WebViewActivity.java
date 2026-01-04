package com.example.androidviewcollection.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewcollection.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.web_view);

        // 1. 配置WebView
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 允许JavaScript执行
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setBuiltInZoomControls(true); // 显示缩放按钮

        // 2. 加载网页（可选：网络URL或本地HTML）
        // 加载网络URL（需在AndroidManifest.xml添加网络权限）
        mWebView.loadUrl("https://www.baidu.com");

        // 加载本地HTML（将文件放在assets文件夹下）
        // mWebView.loadUrl("file:///android_asset/test.html");

        // 3. 处理页面跳转（在当前WebView打开，不跳转到浏览器）
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url); // 在当前WebView加载新URL
                return true;
            }
        });

        // 4. 监听加载进度（可选）
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // 可在此更新进度条
            }
        });
    }

    // 回退键控制网页返回（而非退出Activity）
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack(); // 网页返回上一页
        } else {
            super.onBackPressed(); // 退出Activity
        }
    }
}
