package com.custom.view.day1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.custom.view.R;

/**
 * @Author: kk
 * @Date: 2019-10-17 22:03
 * @Description:
 */
public class CircleView extends View {

    Paint mPaint;
    private int mColor;
    private int radius = 0;

    // java 代码中 new 操作会执行这个方法
    public CircleView(Context context) {
        super(context);

        //初始化画笔
        init();
    }

    // xml 声明时执行该方法
    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //解析自定义属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = ta.getColor(R.styleable.CircleView_circle_color, Color.rgb(100, 100, 100));
        // 解析后释放资源
        ta.recycle();
        init();
    }

    // 不会自动调用
    // 一般在第二个构造函数里主动调用，如 view 有style 属性时
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // API 21 后使用
    // 不会自动调用
    // 一般在第二个构造函数里主动调用，如 view 有style 属性时
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    /**
     * 初始化画笔
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(4f);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //xml 设置对 padding 值要获取并且计算到下面到 width 和 height 才能生效,且圆到中心点也要修改
        final int paddingL = getPaddingLeft();
        final int paddingR = getPaddingRight();
        final int paddingT = getPaddingTop();
        final int paddingB = getPaddingBottom();

        // 获取控件宽高
        int width = getWidth() - paddingL - paddingR;
        int height = getHeight() - paddingT - paddingB;

        // 设置圆对半径
        radius = Math.min(width, height) / 2;

        // 画圆
        canvas.drawCircle(width / 2 + paddingL, height / 2 + paddingT, radius, mPaint);


    }
}
