package com.kk.animation.widget;

import android.animation.TypeEvaluator;
import android.util.Log;

public class ColorEvaluator implements TypeEvaluator {
    private static final String TAG = "ColorEvaluator";
    private int mCurrentRed;
    private int mCurrentGreen;
    private int mCurrentBlue;
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        //获取颜色的初始值和结束值
        String startColor = (String) startValue;
        String endColor = (String) endValue;

        int startRed = Integer.parseInt(startColor.substring(1,3),16);
        int startGreen = Integer.parseInt(startColor.substring(3,5),16);
        int startBlue = Integer.parseInt(startColor.substring(5,7),16);

        int endRed = Integer.parseInt(endColor.substring(1,3),16);
        int endGreen = Integer.parseInt(endColor.substring(3,5),16);
        int endBlue = Integer.parseInt(endColor.substring(5,7),16);

        mCurrentRed = startRed;
        mCurrentGreen = startGreen;
        mCurrentBlue = startBlue;

        int redDiff = endRed - startRed;
        int greenDiff = endGreen - startGreen;
        int blueDiff = endBlue - startBlue;
        int colorDiff = Math.abs(redDiff) + Math.abs(greenDiff) + Math.abs(blueDiff);

        if (mCurrentRed != endRed) {
            mCurrentRed = generateCurColor(startRed,endRed,colorDiff,0,fraction);
        } else if (mCurrentGreen != endGreen){
            mCurrentGreen = generateCurColor(startGreen,endGreen,colorDiff,0,fraction);
        } else if (mCurrentBlue != endBlue){
            mCurrentBlue = generateCurColor(startBlue,endBlue,colorDiff,0,fraction);
        }

        String curColorStr = "#" + getHexString(mCurrentRed) + getHexString(mCurrentGreen) + getHexString(mCurrentBlue);
        return curColorStr;
    }

    /**
     * 根据 fraction 值计算当前颜色
     * @param startColor
     * @param endColor
     * @param colorDiff
     * @param offset
     * @param fraction
     * @return
     */
    private int generateCurColor(int startColor,int endColor,int colorDiff,int offset,float fraction){
        int curColor;
        if (startColor > endColor){
            curColor = (int) (startColor - (fraction * colorDiff - offset));
            if (curColor > endColor){
                curColor = endColor;
            }
        } else {
            curColor = (int) (startColor + (fraction * colorDiff - offset));
            if (curColor > endColor){
                curColor = endColor;
            }
        }

        return curColor;
    }

    /**
     * 把十进制颜色值转换成 16 进制
     * @param value
     * @return
     */
    private String getHexString(int value){
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }

        return hexString;
    }
}
