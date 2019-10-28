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
 * @Description: 贝塞尔曲线-三阶
 */
public class BezierView2 extends View {

    private Paint mPaint;
    private Paint mPointPaint;
    private PointF startP;
    private PointF endP;
    private PointF controlP1;
    private PointF controlP2;

    //控制一个点，是否可以拖拽
    private boolean canDrag1 = false;
    private boolean canDrag2 = false;

    public BezierView2(Context context) {
        super(context);
        init();
    }

    public BezierView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BezierView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化画笔和一些点
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(6);
        mPaint.setStyle(Paint.Style.STROKE);

        mPointPaint = new Paint();
        mPointPaint.setColor(Color.GRAY);
        mPointPaint.setStrokeWidth(15);
        mPointPaint.setStyle(Paint.Style.STROKE);

        startP = new PointF(0, 0);
        endP = new PointF(0, 0);
        controlP1 = new PointF(0, 0);
        controlP2 = new PointF(0, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#abcdef"));
        // 绘制点
        canvas.drawPoint(startP.x, startP.y, mPointPaint);
        canvas.drawPoint(endP.x, endP.y, mPointPaint);
        canvas.drawPoint(controlP1.x, controlP1.y, mPointPaint);
        canvas.drawPoint(controlP2.x, controlP2.y, mPointPaint);

        Path path = new Path();
        path.moveTo(startP.x, startP.y);

        // 控制点和结束点坐标
        path.cubicTo(controlP1.x, controlP1.y, controlP2.x, controlP2.y, endP.x, endP.y);

        canvas.drawPath(path, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //只有在初始化和点击到这个点及附近点时候
        if (controlP1.x == 0) {
            controlP1.x = event.getX();
        }
        if (controlP1.y == 0) {
            controlP1.y = event.getY();
        }
        if (controlP2.x == 0) {
            controlP2.x = event.getX();
        }
        if (controlP2.y == 0) {
            controlP2.y = event.getY();
        }

        //当按下当时候，更新坐标
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Math.abs(event.getX() - controlP1.x) < 5 && Math.abs(event.getY() - controlP1.y) < 5) {
                    //当触摸点和真实点当误差 <10 px 时,才可以拖动点
                    canDrag1 = true;
                }
                if (Math.abs(event.getX() - controlP2.x) < 5 && Math.abs(event.getY() - controlP2.y) < 5) {
                    //当触摸点和真实点当误差 <10 px 时,才可以拖动点
                    canDrag2 = true;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (canDrag1) {
                    controlP1.x = event.getX();
                    controlP1.y = event.getY();
                }
                if (canDrag2) {
                    controlP2.x = event.getX();
                    controlP2.y = event.getY();
                }
                break;
            case MotionEvent.ACTION_UP:
                canDrag1 = false;
                canDrag2 = false;
                break;
            default:
                break;
        }

        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int cenX = getWidth() / 2;
        int cenY = getHeight() / 2;

        startP.x = cenX - 300;
        startP.y = cenY;

        endP.x = cenX + 300;
        endP.y = cenY;

        controlP1.x = cenX - 100;
        controlP1.y = cenY - 200;
        controlP2.x = cenX + 100;
        controlP2.y = cenY - 200;
    }
}
