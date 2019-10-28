package com.design.pattern.SimpleFactory;

/**
 * @Author: kk
 * @Date: 2019-10-20 23:02
 * @Description: 使用简单工厂模式
 */
public class Main {
    public static void main(String[] args) {

        Car car = Factory.manufactureCar(null);
        car.product();
    }
}
