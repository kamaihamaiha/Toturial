package com.kk.animation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyCircle extends View {
    private static final float RADIUS = 60F;
    private Point curPoint;
    private Paint mPaint;

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#558EF4"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (curPoint == null) {
            curPoint = new Point(50,50);

            //以这个点为圆心，画圆
            float x = curPoint.getX();
            float y = curPoint.getY();
            canvas.drawCircle(x,y,RADIUS,mPaint);

            //将属性动画作用到 view 中
            Point startP = new Point(RADIUS,RADIUS);
            Point endP = new Point(800,800);

            ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(),startP,endP);
            valueAnimator.setDuration(5000L);

            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    curPoint = (Point) valueAnimator.getAnimatedValue();
                    invalidate();
                }
            });

            valueAnimator.start();
        } else {
            //如果不为空，则画圆
            float x = curPoint.getX();
            float y = curPoint.getY();
            canvas.drawCircle(x,y,RADIUS,mPaint);
        }
    }
}
