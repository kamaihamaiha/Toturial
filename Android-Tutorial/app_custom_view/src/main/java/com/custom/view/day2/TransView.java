package com.custom.view.day2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-21 09:35
 * @Description:
 */
public class TransView extends View {
    private Paint mPaint;
    public TransView(Context context) {
        super(context);
        init();
    }

    public TransView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TransView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 给画布上色
        canvas.drawColor(Color.parseColor("#5B6061"));

        // 先画一个圆
        canvas.drawCircle(0,0,100,mPaint);

        // 移动画布
        canvas.translate(250,250);

        // 再画一个圆
        canvas.drawCircle(0,0,200,mPaint);

        // 用文字描述画布
        canvas.translate(0,400);
        mPaint.setTextSize(50);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.WHITE);
        canvas.drawText("Canvas Translate",0,0,mPaint);
    }
}
