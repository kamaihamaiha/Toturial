package com.custom.view.day3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.custom.view.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: kk
 * @Date: 2019-10-22 12:02
 * @Description: 绘制位图
 */
public class DrawBitmapView extends View {


    private Bitmap terrifiedBitmap;
    private Bitmap kkBitmap;
    private Bitmap kittyBitmap;

    private int tag;

    public DrawBitmapView(Context context) {
        super(context);
        init(context);
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        kkBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.kk);
        try {
            InputStream bitmapIs = context.getAssets().open("terrified.png");
            terrifiedBitmap = BitmapFactory.decodeStream(bitmapIs);
            bitmapIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        kittyBitmap = BitmapFactory.decodeFile("/sdcard/kitty.jpg");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        switch (tag) {
            case 1:
                //way1
                canvas.drawBitmap(kkBitmap, new Matrix(), new Paint());
                break;
            case 2:
                //way2. 从距离 左边 100px 上面 100px 开始绘制
                canvas.drawBitmap(kkBitmap, 100, 100, new Paint());
                break;
            case 3:
                //way3
                canvas.drawColor(Color.GRAY);
//                canvas.translate(getWidth() / 2,getHeight() / 2);
                // bitmap 原图对区域
                Rect srcRect = new Rect(0, 0, kittyBitmap.getWidth() / 2, kittyBitmap.getHeight() / 2);
                // 在画布上面绘制对区域,绘制内容就是原图指定对区域，只不过会根据画布绘制区域缩放
                Rect dstRect = new Rect(0, 0, 500, 500);

                canvas.drawBitmap(kittyBitmap, srcRect, dstRect, new Paint());
                break;
            default:
                break;
        }

    }

    public void play(int index) {
        tag = index;
        invalidate();
    }
}
