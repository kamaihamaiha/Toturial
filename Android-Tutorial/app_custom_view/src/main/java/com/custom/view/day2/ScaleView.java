package com.custom.view.day2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-21 09:35
 * @Description:
 */
public class ScaleView extends View {
    private Paint mPaint;

    public ScaleView(Context context) {
        super(context);
        init();
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 给画布上色
        canvas.drawColor(Color.parseColor("#a46061"));

        // 移动画布到中心位置
        canvas.translate(getWidth() / 2, getHeight() / 2);

        // 画坐标轴
        canvas.drawLine(0, -getHeight() / 2, 0, getHeight() / 2, mPaint);
        canvas.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0, mPaint);

        // 画一个矩形
        mPaint.setColor(Color.BLACK);
        RectF rectF = new RectF(0, 0, 300, -300);
        canvas.drawRect(rectF, mPaint);

        // 用文字描述画布
        mPaint.setTextSize(30);
        mPaint.setStrokeWidth(2);
        canvas.drawText("Canvas Scale", 300, -350, mPaint);

        // 缩放画布
        canvas.scale(0.5f, 0.5f);
        canvas.drawRect(rectF, mPaint);

        // 缩放画布,缩放中心向右移动 150px
        canvas.scale(0.5f, 0.5f, 150, 0);
        canvas.drawRect(rectF, mPaint);

        // 如果缩放比例是 < 0,那么就会翻转
        // 先恢复到原来比例
        canvas.translate(-150,0);
        canvas.scale(4.0f,4.0f);

        canvas.scale(-1.0f,-1.0f);
        canvas.drawRect(rectF,mPaint);

        //往右翻转,然后画很多个圆
        canvas.scale(-1.0f,1.0f);
        for (int i = 0; i < 20; i++) {
            canvas.drawRect(rectF,mPaint);
            canvas.scale(0.9f,0.9f);
        }

    }
}
