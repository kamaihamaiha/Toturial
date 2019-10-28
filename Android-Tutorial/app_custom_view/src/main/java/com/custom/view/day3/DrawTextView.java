package com.custom.view.day3;

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
 * @Date: 2019-10-22 20:00
 * @Description:
 * 绘制文字部分大致可以分为三类：
 *
 * 第一类只能指定文本基线位置(基线x默认在字符串左侧，基线y默认在字符串下方)。
 * 第二类可以分别指定每个文字的位置。
 * 第三类是指定一个路径，根据路径绘制文字。
 */
public class DrawTextView extends View {

    private Paint mPaint;

    public DrawTextView(Context context) {
        super(context);
        init();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setTextSize(40);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Hello World!",50,50,mPaint);
        canvas.translate(getWidth() / 2,getHeight() / 2);
        canvas.rotate(90);
        canvas.drawText("Hello World!",0,6,0,0,mPaint);
    }
}
