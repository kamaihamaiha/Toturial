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
 * @Description: 多个 Path 叠加
 */
public class PathAdd extends View {
    private Paint mPaint;
    //画坐标轴到笔
    private Paint mAxisPaint;
    private Path mPath;
    public PathAdd(Context context) {
        super(context);
        init();
    }

    public PathAdd(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathAdd(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        mPath.lineTo(100,-50);
        Path tempPath = new Path();
        tempPath.addCircle(100,-50,50, Path.Direction.CW);
        // 往右平移 50
        tempPath.offset(0,-50);

        Path tempPath2 = new Path();
        tempPath2.addCircle(-200,-200,80, Path.Direction.CW);
        mPath.addPath(tempPath);
        mPath.addPath(tempPath2);

        canvas.drawPath(mPath,mPaint);
    }
}
