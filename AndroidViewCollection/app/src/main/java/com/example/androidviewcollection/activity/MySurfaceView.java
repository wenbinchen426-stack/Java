package com.example.androidviewcollection.activity; // 必须与布局中的包名完全一致

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

// 自定义 SurfaceView，必须继承 SurfaceView 并实现 SurfaceHolder.Callback 和 Runnable
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder mHolder; //  Surface 控制器
    private Canvas mCanvas; // 绘图画布
    private Thread mDrawThread; // 绘图子线程（避免阻塞主线程）
    private boolean isDrawing = false; // 绘图开关
    private Paint mPaint; // 画笔（用于绘图）

    // 必须实现的构造方法（布局引用时会调用此构造）
    public MySurfaceView(Context context) {
        super(context);
        initView(); // 初始化绘图相关参数
    }

    // 可选：若布局中用了自定义属性，需添加此构造（避免膨胀布局时报错）
    public MySurfaceView(Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    // 初始化：获取控制器、注册回调、初始化画笔
    private void initView() {
        mHolder = getHolder();
        mHolder.addCallback(this); // 注册 Surface 生命周期回调（创建/销毁/尺寸变化）

        // 初始化画笔（示例：画红色圆形）
        mPaint = new Paint();
        mPaint.setColor(Color.RED); // 画笔颜色
        mPaint.setAntiAlias(true); // 抗锯齿（让图形边缘更平滑）
        mPaint.setStyle(Paint.Style.FILL); // 填充模式（画实心图形）

        // 允许获取焦点（可选，若需要处理触摸事件）
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    // -------------------------- SurfaceHolder.Callback 回调方法 --------------------------
    // 1. Surface 创建时调用（如页面初始化）：启动绘图线程
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        mDrawThread = new Thread(this); // 启动子线程绘图
        mDrawThread.start();
    }

    // 2. Surface 尺寸变化时调用（如屏幕旋转）：可重新调整绘图尺寸
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    // 3. Surface 销毁时调用（如页面关闭）：停止绘图线程，避免内存泄漏
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false; // 停止绘图循环
        // 等待线程安全结束（避免线程还在运行时销毁 Surface）
        try {
            mDrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // -------------------------- Runnable 绘图逻辑（子线程中执行） --------------------------
    @Override
    public void run() {
        int circleX = 50; // 圆形的X坐标（用于让圆形移动）
        // 循环绘图（直到 isDrawing 为 false）
        while (isDrawing) {
            try {
                // 1. 锁定画布（获取绘图权限，避免多线程冲突）
                mCanvas = mHolder.lockCanvas();
                if (mCanvas != null) { // 必须判空（避免 Surface 销毁后画布为空）
                    // 2. 清空画布（每次绘图前先画背景，避免图形重叠）
                    mCanvas.drawColor(Color.WHITE); // 白色背景

                    // 3. 绘制图形（示例：移动的圆形）
                    mCanvas.drawCircle(circleX, getHeight() / 2, 50, mPaint); // 画圆（X坐标/Y坐标/半径/画笔）

                    // 4. 更新圆形位置（让圆形向右移动，超出屏幕后重置）
                    circleX += 3;
                    if (circleX > getWidth() + 50) { // 超出屏幕右侧后重置到左侧
                        circleX = -50;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 5. 解锁画布并提交（必须在 finally 中执行，确保无论是否报错都释放画布）
                if (mCanvas != null) {
                    mHolder.unlockCanvasAndPost(mCanvas);
                }
            }

            // 控制绘图帧率（避免过度消耗CPU，示例：每50毫秒画一次，约20帧）
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}