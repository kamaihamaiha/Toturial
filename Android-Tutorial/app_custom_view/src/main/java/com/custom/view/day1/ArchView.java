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
 * @Description: 画圆弧
 */
public class ArchView extends View {

    private static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_BG_COLOR = Color.GRAY;
    private Paint mPaint;
    private int mPaintColor = DEFAULT_COLOR;
    private int mBGColor = DEFAULT_BG_COLOR;

    public ArchView(Context context) {
        super(context);
        init();
    }

    public ArchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        canvas.drawArc(new RectF(20,20,200,200),0,90,false,mPaint );
        canvas.translate(getWidth() / 2,getHeight() / 2);
        canvas.drawArc(0,0,200,200,0,90,true,mPaint);

    }
}
