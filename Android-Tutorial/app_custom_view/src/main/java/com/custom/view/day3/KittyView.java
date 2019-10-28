package com.custom.view.day3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: kk
 * @Date: 2019-10-22 15:56
 * @Description: 让小猫的图片显示动画效果，用 canvas 实现
 */
public class KittyView extends View {
    private static final String TAG = "KittyView";
    private Bitmap bitmap;
    private Paint mPaint;
    private int progress = 0;
    private int curSrcHeight = 0;
    private int curDesHeight = 0;

    public KittyView(Context context) {
        super(context);
        init(context);
    }

    public KittyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public KittyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        bitmap = BitmapFactory.decodeFile("/sdcard/kitty.jpg");
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 先画个背景色
        canvas.drawColor(Color.parseColor("#3a0d77"));

        Rect srcDest = new Rect(0, 0,bitmap.getWidth() , 0);
        Rect dstDest = new Rect(0, 0, getWidth(), getHeight());

        int bitmapHeight = bitmap.getHeight();


        int stepSrcHeight = bitmapHeight / 50;
        int stepCanvasHeight = getHeight() / 50;



        if (progress < 50){
           srcDest.set(0,0,bitmap.getWidth(),curSrcHeight);
           dstDest.set(0,0,getWidth(),curDesHeight);
           canvas.drawBitmap(bitmap,srcDest,dstDest,mPaint);
           curSrcHeight += stepSrcHeight;
           curDesHeight += stepCanvasHeight;
           postInvalidateDelayed(10);
       }
    }
}
