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
 * @Description: 保存快照和回滚。先画三个点，然后分别以点为中心画圆
 * canvas.save() 保存到状态栈
 * canvas.restore() 从状态栈顶取出状态，按照这个状态恢复当前画布
 */
public class SaveAndRestoreView extends View {
    private Paint mPaint;

    public SaveAndRestoreView(Context context) {
        super(context);
        init();
    }

    public SaveAndRestoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SaveAndRestoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 给画布上色
        canvas.drawColor(Color.parseColor("#876543"));

        canvas.translate(50, 50);
        canvas.save();
        canvas.drawPoint(0, 0, mPaint);

        canvas.translate(100, 0);
        canvas.save();
        mPaint.setColor(Color.RED);
        canvas.drawPoint(0, 0, mPaint);

        canvas.translate(0, 150);
        canvas.save();
        mPaint.setColor(Color.GREEN);
        canvas.drawPoint(0, 0, mPaint);

        canvas.restore();
        canvas.drawCircle(0, 0, 60, mPaint);

        canvas.restore();
        mPaint.setColor(Color.RED);
        canvas.drawCircle(0, 0, 40, mPaint);

        canvas.restore();
        canvas.drawCircle(0, 0, 30, mPaint);


    }
}
