package com.custom.view.day1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-20 18:28
 * @Description: 画椭圆
 */
public class OvalView extends View {

    private static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_BG_COLOR = Color.parseColor("#aaaaaa");
    private Paint mPaint;
    private int mPaintColor = DEFAULT_COLOR;
    private int mBGColor = DEFAULT_BG_COLOR;

    public OvalView(Context context) {
        super(context);
        init();
    }

    public OvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mPaintColor);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(mBGColor);

        canvas.translate(getWidth() / 2,getHeight() / 2);

        canvas.drawOval(-150,-100,150,100,mPaint);
    }
}
