package com.custom.view.day1;

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
 * @Date: 2019-10-20 18:28
 * @Description: 画点
 */
public class PointView extends View {

    private static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_BG_COLOR = Color.GRAY;
    private Paint mPaint;
    private int mPaintColor = DEFAULT_COLOR;
    private int mBGColor = DEFAULT_BG_COLOR;

    public PointView(Context context) {
        super(context);
        init();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mPaintColor);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(mBGColor);

        canvas.drawLine(-100,-100,100,100,mPaint);

        canvas.drawLines(new float[]{
                -150,-150,100,-150,
                -150,-50,100,-50,
                150,-50,150,150,
        },mPaint);
    }
}
