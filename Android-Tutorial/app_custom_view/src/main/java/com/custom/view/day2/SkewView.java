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
 * @Description: 旋转偏斜
 */
public class SkewView extends View {
    private Paint mPaint;
    public SkewView(Context context) {
        super(context);
        init();
    }

    public SkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 给画布上色
        canvas.drawColor(Color.parseColor("#60615B"));

        canvas.translate(getWidth() / 2 - 100,getHeight() / 2 - 100);

        RectF rectF = new RectF(0, 0, 200, 200);
        canvas.drawRect(rectF,mPaint);

        canvas.skew(1.0f,0.5f);
        canvas.drawRect(rectF,mPaint);


    }
}
