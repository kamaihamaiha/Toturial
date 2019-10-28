package com.custom.view.day1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.custom.view.R;

/**
 * @Author: kk
 * @Date: 2019-10-20 15:41
 * @Description: 太极图
 * 核心操作在 自定义属性和 onDraw() 方法
 */
public class TaijiView extends View {

    private Paint mSunPaint;
    private Paint mMoonPaint;
    private int degree;
    private boolean isRotate;
    private int mSunColor;
    private int mMoonColor;
    private float rotateLevel;

    public TaijiView(Context context) {
        super(context);

        initPaint();
    }

    public TaijiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TaijiView);
        isRotate = attributes.getBoolean(R.styleable.TaijiView_rotate, false);
        mMoonColor = attributes.getColor(R.styleable.TaijiView_moon_color, Color.BLACK);
        mSunColor = attributes.getColor(R.styleable.TaijiView_sun_color, Color.WHITE);
        rotateLevel = attributes.getInt(R.styleable.TaijiView_rotate_level, 2);
        initPaint();
    }

    public TaijiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mSunPaint = new Paint();
        mSunPaint.setColor(mSunColor);
        mSunPaint.setAntiAlias(true);
        mSunPaint.setStyle(Paint.Style.FILL);

        mMoonPaint = new Paint();
        mMoonPaint.setColor(mMoonColor);
        mMoonPaint.setAntiAlias(true);
        mMoonPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int paddingL = getPaddingLeft();
        int paddingR = getPaddingRight();
        int paddingT = getPaddingTop();
        int paddingB = getPaddingBottom();

        int realWidth = width - paddingL - paddingR;
        int realHeight = height - paddingT - paddingB;

        int radius = Math.min(realWidth, realHeight) / 2;
        RectF rectF = new RectF(-radius, -radius, radius, radius);

        canvas.translate(width / 2, height / 2);

        canvas.drawColor(Color.YELLOW);
        canvas.rotate(degree);

        // 画半圆
        canvas.drawArc(rectF, 90, 180, true, mSunPaint);
        canvas.drawArc(rectF, -90, 180, true, mMoonPaint);

        //画小圆
        int smallRadius = radius / 2;
        canvas.drawCircle(0, -smallRadius, smallRadius, mSunPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, mMoonPaint);

        //画眼
        int eyeRadius = smallRadius / 4;
        canvas.drawCircle(0, -smallRadius, eyeRadius, mMoonPaint);
        canvas.drawCircle(0, smallRadius, eyeRadius, mSunPaint);

        if (isRotate) {
            postInvalidateDelayed(50);
            degree += 20 * (rotateLevel / 2);
        }
    }
}
