package com.example.androidviewcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidviewcollection.activity.ButtonActivity;
import com.example.androidviewcollection.activity.CheckBoxActivity;
import com.example.androidviewcollection.activity.ConstraintLayoutActivity;
import com.example.androidviewcollection.activity.EditTextActivity;
import com.example.androidviewcollection.activity.FrameLayoutActivity;
import com.example.androidviewcollection.activity.GridViewActivity;
import com.example.androidviewcollection.activity.ImageViewActivity;
import com.example.androidviewcollection.activity.LinearLayoutActivity;
import com.example.androidviewcollection.activity.ListViewActivity;
import com.example.androidviewcollection.activity.ProgressBarActivity;
import com.example.androidviewcollection.activity.RadioButtonActivity;
import com.example.androidviewcollection.activity.RatingBarActivity;
import com.example.androidviewcollection.activity.RecyclerViewActivity;
import com.example.androidviewcollection.activity.RelativeLayoutActivity;
import com.example.androidviewcollection.activity.ScrollViewActivity;
import com.example.androidviewcollection.activity.SeekBarActivity;
import com.example.androidviewcollection.activity.SurfaceViewActivity;
import com.example.androidviewcollection.activity.TableLayoutActivity;
import com.example.androidviewcollection.activity.TextViewActivity;
import com.example.androidviewcollection.activity.ToggleButtonActivity;
import com.example.androidviewcollection.activity.ViewPagerActivity;
import com.example.androidviewcollection.activity.WebViewActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initView();
        setClickListeners();
        // 单独的方法设置点击监听器
    }
    // 初始化所有视图
    private void initView() {
    // 为所有需要初始化的视图设置初始状态
    }
    private void setClickListeners() {
        // 为所有需要点击的视图设置监听器
        findViewById(R.id.text_view).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.edit_text).setOnClickListener(this);
        findViewById(R.id.image_view).setOnClickListener(this);
        findViewById(R.id.check_box).setOnClickListener(this);
        findViewById(R.id.radio_button).setOnClickListener(this);
        findViewById(R.id.toggle_button).setOnClickListener(this);
        findViewById(R.id.linear_layout).setOnClickListener(this);
        findViewById(R.id.relative_layout).setOnClickListener(this);
        findViewById(R.id.frame_layout).setOnClickListener(this);
        findViewById(R.id.table_layout).setOnClickListener(this);
        findViewById(R.id.constraint_layout).setOnClickListener(this);
        findViewById(R.id.list_view).setOnClickListener(this);
        findViewById(R.id.grid_view).setOnClickListener(this);
        findViewById(R.id.recycler_view).setOnClickListener(this);
        findViewById(R.id.view_pager).setOnClickListener(this);
        findViewById(R.id.seek_bar).setOnClickListener(this);
        findViewById(R.id.progress_bar).setOnClickListener(this);
        findViewById(R.id.rating_bar).setOnClickListener(this);
        findViewById(R.id.surface_view).setOnClickListener(this);
        findViewById(R.id.web_view).setOnClickListener(this);
        findViewById(R.id.scroll_view).setOnClickListener(this);
    }

    // 实现点击事件处理方法（补全ToggleButton和SurfaceView的跳转逻辑）
    @Override
    public void onClick(View v) {
        int id = v.getId();
        String viewName = "";
        Intent intent = null;

        if (id == R.id.text_view) {
            viewName = "TextView";
            intent = new Intent(MainActivity.this, TextViewActivity.class);
        } else if (id == R.id.button) {
            viewName = "Button";
            intent = new Intent(MainActivity.this, ButtonActivity.class);
        } else if (id == R.id.edit_text) {
            viewName = "EditText";
            intent = new Intent(MainActivity.this, EditTextActivity.class);
        } else if (id == R.id.image_view) {
            viewName = "ImageView";
            intent = new Intent(MainActivity.this, ImageViewActivity.class);
        } else if (id == R.id.check_box) {
            viewName = "CheckBox";
            intent = new Intent(MainActivity.this, CheckBoxActivity.class);
        } else if (id == R.id.radio_button) {
            viewName = "RadioButton";
            intent = new Intent(MainActivity.this, RadioButtonActivity.class);
        } else if (id == R.id.toggle_button) {
            viewName = "ToggleButton";
            intent = new Intent(MainActivity.this, ToggleButtonActivity.class);
        } else if (id == R.id.linear_layout) {
            viewName = "LinearLayout";
            intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
        } else if (id == R.id.relative_layout) {
            viewName = "RelativeLayout";
            intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
        } else if (id == R.id.frame_layout) {
            viewName = "FrameLayout";
            intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
        } else if (id == R.id.table_layout) {
            viewName = "TableLayout";
            intent = new Intent(MainActivity.this, TableLayoutActivity.class);
        } else if (id == R.id.constraint_layout) {
            viewName = "ConstraintLayout";
            intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
        } else if (id == R.id.list_view) {
            viewName = "ListView";
            intent = new Intent(MainActivity.this, ListViewActivity.class);
        } else if (id == R.id.grid_view) {
            viewName = "GridView";
            intent = new Intent(MainActivity.this, GridViewActivity.class);
        } else if (id == R.id.recycler_view) {
            viewName = "RecyclerView";
            intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        } else if (id == R.id.view_pager) {
            viewName = "ViewPager";
            intent = new Intent(MainActivity.this, ViewPagerActivity.class);
        } else if (id == R.id.seek_bar) {
            viewName = "SeekBar";
            intent = new Intent(MainActivity.this, SeekBarActivity.class);
        } else if (id == R.id.progress_bar) {
            viewName = "ProgressBar";
            intent = new Intent(MainActivity.this, ProgressBarActivity.class);
        } else if (id == R.id.rating_bar) {
            viewName = "RatingBar";
            intent = new Intent(MainActivity.this, RatingBarActivity.class);
        } else if (id == R.id.surface_view) {
            viewName = "SurfaceView";
            intent = new Intent(MainActivity.this, SurfaceViewActivity.class);
        } else if (id == R.id.web_view) {
            viewName = "WebView";
            intent = new Intent(MainActivity.this, WebViewActivity.class);
        }else if (id == R.id.scroll_view) {
            viewName = "ScrollView";
            intent = new Intent(MainActivity.this, ScrollViewActivity.class);
        }

        // 显示提示并跳转
        Toast.makeText(this,  "点击了: " + viewName + " 正在跳转" + viewName + "视图..." , Toast.LENGTH_SHORT).show();
        if (intent != null) {
            startActivity(intent);
        }
    }
}