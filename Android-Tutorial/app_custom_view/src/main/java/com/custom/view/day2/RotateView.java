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
 * @Description: 旋转画布
 */
public class RotateView extends View {
    private Paint mPaint;
    public RotateView(Context context) {
        super(context);
        init();
    }

    public RotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        canvas.drawColor(Color.parseColor("#605B61"));

        canvas.translate(getWidth() / 2,getHeight() / 2);

        float outRadius = 300;
        float innerRadius = 270;
        canvas.drawCircle(0,0,outRadius,mPaint);
        canvas.drawCircle(0,0,innerRadius,mPaint);

        //画连接大圆和校园到线
        for (int i = 0; i <= 30; i++) {
            canvas.drawLine(270,0,300,0,mPaint);
            canvas.rotate(12);
        }

    }
}
