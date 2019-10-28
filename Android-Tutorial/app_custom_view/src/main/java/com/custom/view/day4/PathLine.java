package com.custom.view.day4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-23 10:33
 * @Description: 画线用 Path
 * Path.lineTo（）
 * Canvas.drawPath（）
 *
 */
public class PathLine extends View {

    private Paint mPaint;
    private Path mPath;

    public PathLine(Context context) {
        super(context);
        init();
    }

    public PathLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(6);

        mPath = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.GRAY);

        // 画中垂线,
        // 把画布的坐标系移动到顶部居中
        canvas.translate(getWidth() / 2, 0);
        mPath.lineTo(0, getHeight());

        // 画居中的水平线
        mPath.moveTo(-1 * getWidth() / 2, getHeight() / 2);
        mPath.rLineTo(getWidth(),0);

        // 顺时针画闭合线
        mPath.rLineTo(-1 * getWidth() / 2,getHeight() / 2);
        mPath.rLineTo(-1 * getWidth() / 2,-1*getHeight() / 2);
        mPath.rLineTo(getWidth() / 2,-1*getHeight() / 2);
        mPath.rLineTo(getWidth() / 2,getHeight() / 2);


        mPath.lineTo(50,150);

        // 闭合路线，把当前最后一点和最初到点连起来。如果 2 个点连起来不能闭合那就不连了。
//        mPath.close();

        canvas.drawPath(mPath, mPaint);



    }
}
