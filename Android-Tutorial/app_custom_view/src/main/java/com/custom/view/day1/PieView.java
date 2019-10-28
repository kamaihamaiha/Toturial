package com.custom.view.day1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;


/**
 * @Author: kk
 * @Date: 2019-10-20 19:34
 * @Description: 画饼状图
 */
public class PieView extends View {

    private static final String TAG = "PieView";
    private Paint mPaint;
    private Paint mTextPaint;
    private int mPaintColor = Color.BLACK;
    private List<PieData> pieDataList;
    private float startAngle = 0;
    private double diffY;

    public PieView(Context context) {
        super(context);
        init();
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mPaintColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.RED);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setStrokeWidth(15);
        mTextPaint.setTextSize(36);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int width = getWidth();
        int height = getHeight();
        if (pieDataList != null) {
            startAngle = 0;
            canvas.drawColor(Color.parseColor("#516AD9"));
            Log.d(TAG, "onDraw: start draw fan");
            for (PieData pieData : pieDataList) {
                mPaint.setColor(pieData.getColor());
                canvas.drawArc(0, 0, width, height, startAngle, pieData.getAngle(),
                        true, mPaint);

                //计算文字位置，文字写在扇区中间，偏外侧位置
                float textAngle = startAngle + (pieData.getAngle() / 2);
                float shortLine = width / 2.0f * 0.7f;
                double cosValue = Math.cos(textAngle * Math.PI / 180);
                double sinValue = Math.sin(textAngle * Math.PI / 180);
                double diffX = shortLine * cosValue;
                double diffY = shortLine * sinValue;
                float x = (float) (width / 2 + diffX);
                float y = (float) (height / 2 + diffY);



                Log.d(TAG, "onDraw: x,y=(" + x + "," + y + ")");
                canvas.drawText(pieData.getPercent() / 10 + "%", x, y, mTextPaint);
                startAngle += pieData.getAngle();
            }
        }


    }

    public void setData(List<PieData> pieDatas) {
        this.pieDataList = pieDatas;

        int startColor = Color.BLACK;
        int endColor = Color.WHITE;

        int diffColor = (endColor - startColor) / (pieDataList.size() == 0 ? 1 : pieDataList.size());
        int totalValue = 0;
        for (PieData pieData : pieDataList) {
            totalValue += pieData.getValue();
        }

        int curColor = endColor;
        for (PieData pieData : pieDataList) {
            curColor -= diffColor;
            pieData.setColor(curColor);

            pieData.setPercent(pieData.getValue() * 1.0f / totalValue);
            pieData.setAngle(pieData.getPercent() / 1000 * 360);
        }

        invalidate();
    }
}
