package com.custom.view.day3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-22 09:35
 * @Description: 绘制图片之矢量图
 */
public class DrawPicture extends View {

    private Paint mPaint;
    private Picture picture;
    private int count = 0;

    public DrawPicture(Context context) {
        super(context);
        init();
    }

    public DrawPicture(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPicture(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#764fac"));
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);

        picture = new Picture();
        Canvas canvas = picture.beginRecording(400, 400);

        canvas.translate(200, 200);
        canvas.drawColor(Color.GRAY);
        canvas.drawCircle(0, 0, 150, mPaint);

        picture.endRecording();

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (picture != null) {
            if (count == 0) {
                canvas.drawPicture(picture);
            } else if (count == 1){
                //加上 第二个参数，会在指定区域绘制。有缩放【放大或放小】效果
                canvas.drawPicture(picture, new RectF(0, 0, 500, 500));
            } else {
                // 用 PictureDrawable 绘制。
                PictureDrawable pictureDrawable = new PictureDrawable(picture);

                // 设置边界，不是缩放。仅仅是在这个区域中绘制。
                pictureDrawable.setBounds(0,0,300,200);
                pictureDrawable.draw(canvas);
            }
            count++;
        }
        if (count < 3){
            postInvalidateDelayed(1000);
        }
    }

}
