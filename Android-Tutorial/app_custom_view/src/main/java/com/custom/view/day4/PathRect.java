package com.custom.view.day4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-23 11:37
 * @Description: 画矩形用 Path
 * 重点理解，画矩形，实际上是按照顺序【顺时针或者逆时针】画线，达到画矩形到效果。
 * 如果用 setLastPoint() 重新设置了新的 path 最后到点，画的就不是矩形了。
 */
public class PathRect extends View {
    private Paint mPaint;
    //画坐标轴到笔
    private Paint mAxisPaint;
    private Path mPath;
    public PathRect(Context context) {
        super(context);
        init();
    }

    public PathRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(6);

        mAxisPaint = new Paint();
        mAxisPaint.setStyle(Paint.Style.STROKE);
        mAxisPaint.setColor(Color.RED);
        mAxisPaint.setStrokeWidth(2);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.GRAY);
        canvas.translate(getWidth() / 2,getHeight() / 2);
        // 先画出坐标系
        canvas.drawLine(-1 * getWidth() / 2,0,getWidth() / 2,0,mAxisPaint);
        canvas.drawLine(0,-1 * getHeight() / 2,0,getHeight() / 2,mAxisPaint);

        // 用 path 设置好矩形路径

        RectF rectF = new RectF(-300, -300, 300, 300);
        mPath.addRect(rectF, Path.Direction.CCW);
        mPath.setLastPoint(-250,350);
        canvas.drawPath(mPath,mPaint);

    }
}
