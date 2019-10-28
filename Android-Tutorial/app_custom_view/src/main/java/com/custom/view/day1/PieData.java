package com.custom.view.day1;

import java.math.BigDecimal;

/**
 * @Author: kk
 * @Date: 2019-10-20 19:36
 * @Description: 饼状图的扇形数据
 */
public class PieData {
    private String name;
    private int value;
    private int percent;

    private int color;
    private float angle;

    public PieData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        BigDecimal bigDecimal = new BigDecimal(percent * 1000);
        this.percent = (int) bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
