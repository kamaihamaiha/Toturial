package com.custom.view.day5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-28 10:19
 * @Description: 贝塞尔曲线-画心
 */
public class BezierViewHeart extends View {
    private static final float C = 0.551915024494f;     // 一个常量，用来计算绘制圆形贝塞尔曲线控制点的位置

    private Paint mPaint;
    private Paint mPointPaint;
    private Paint mControlPointPaint;
    //画坐标系到笔
    private Paint mCoordinatePaint;
    private PointF[] controlPs;
    private PointF[] fixedPs;
    private int radius = 300;

    //控制一个点，是否可以拖拽
    private boolean canDrag = false;

    public BezierViewHeart(Context context) {
        super(context);
        init();
    }

    public BezierViewHeart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierViewHeart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化画笔和一些点
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(9);
        mPaint.setStyle(Paint.Style.STROKE);

        mPointPaint = new Paint();
        mPointPaint.setColor(Color.GRAY);
        mPointPaint.setStrokeWidth(15);
        mPointPaint.setStyle(Paint.Style.STROKE);

        mControlPointPaint = new Paint();
        mControlPointPaint.setColor(Color.BLUE);
        mControlPointPaint.setStrokeWidth(12);
        mControlPointPaint.setStyle(Paint.Style.STROKE);

        mCoordinatePaint = new Paint();
        mCoordinatePaint.setColor(Color.GRAY);
        mCoordinatePaint.setStrokeWidth(3);
        mCoordinatePaint.setStyle(Paint.Style.STROKE);

        controlPs = new PointF[8];
        for (int i = 0; i < 8; i++) {
            controlPs[i] = new PointF();
        }
        fixedPs = new PointF[4];
        for (int i = 0; i < 4; i++) {
            fixedPs[i] = new PointF();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#abcdef"));

        // 绘制坐标轴
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mCoordinatePaint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mCoordinatePaint);

        canvas.translate(getWidth() / 2, getHeight() / 2);
        // 绘制点
        for (PointF fixedP : fixedPs) {
            canvas.drawPoint(fixedP.x, fixedP.y, mPointPaint);
        }

        for (PointF controlP : controlPs) {
            canvas.drawPoint(controlP.x, controlP.y, mControlPointPaint);
        }

        for (int i = 0; i < 4; i++) {

            Path path = new Path();
            path.moveTo(fixedPs[i].x, fixedPs[i].y);
            path.cubicTo(controlPs[i * 2].x, controlPs[i * 2].y, controlPs[(i * 2) + 1].x, controlPs[(i * 2) + 1].y,
                    fixedPs[(i + 1) % 4].x, fixedPs[(i + 1) % 4].y);
            canvas.drawPath(path, mPaint);
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //只有在初始化和点击到这个点及附近点时候
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        fixedPs[0].x = 0;
        fixedPs[0].y = -radius;
        fixedPs[1].x = radius;
        fixedPs[1].y = 0;
        fixedPs[2].x = 0;
        fixedPs[2].y = radius;
        fixedPs[3].x = -radius;
        fixedPs[3].y = 0;

        controlPs[0].x = fixedPs[0].x + radius * C;
        controlPs[0].y = fixedPs[0].y;
        controlPs[1].x = radius;
        controlPs[1].y = -1 * radius * C;
        controlPs[2].x = radius;
        controlPs[2].y = radius * C;
        controlPs[3].x = radius * C;
        controlPs[3].y = radius;
        controlPs[4].x = -1 * radius * C;
        controlPs[4].y = radius;
        controlPs[5].x = -1 * radius;
        controlPs[5].y = radius * C;
        controlPs[6].x = -1 * radius;
        controlPs[6].y = -1 * radius * C;
        controlPs[7].x = -1 * radius * C;
        controlPs[7].y = -1 * radius;


    }
}
