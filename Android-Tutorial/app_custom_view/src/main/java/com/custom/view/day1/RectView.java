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
 * @Description: 画矩形
 */
public class RectView extends View {

    private static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_BG_COLOR = Color.GRAY;
    private Paint mPaint;
    private int mPaintColor = DEFAULT_COLOR;
    private int mBGColor = DEFAULT_BG_COLOR;

    public RectView(Context context) {
        super(context);
        init();
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mPaintColor);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(mBGColor);

        canvas.drawRect(20,20,130,130,mPaint);
        canvas.translate(getWidth() / 2,getHeight() / 2);
        canvas.drawRoundRect(-50,-50,50,50,20,20,mPaint);

        //rx ry 超过 x y 的一半时，就是椭圆来
        canvas.drawRoundRect(-180,0,-80,150,50,75,mPaint);

    }
}
