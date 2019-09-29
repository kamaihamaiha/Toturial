package com.kk.animation.widget;

import android.animation.TypeEvaluator;

/**
 * 作用是，自定义从初始坐标过渡到结束坐标
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startP = (Point) startValue;
        Point endP = (Point) endValue;
        float x = startP.getX() + fraction * (endP.getX() - startP.getX());
        float y = startP.getY() + fraction * (endP.getY() - startP.getY());
        return new Point(x,y);
    }
}
