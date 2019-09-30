package com.kk.animation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyCircle2 extends View {

    private static final float RADIUS = 88F;
    private Point p;
    private String color;
    private Paint mPaint;

    public MyCircle2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        p = new Point(300,100);
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));

        //重绘
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(p.getX(),p.getY(),RADIUS,mPaint);
    }
}
