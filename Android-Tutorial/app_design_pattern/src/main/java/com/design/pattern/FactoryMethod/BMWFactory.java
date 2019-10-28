package com.design.pattern.FactoryMethod;

/**
 * @Author: kk
 * @Date: 2019-10-21 19:36
 * @Description:
 */
public class BMWFactory extends Factory {
    @Override
    Car product() {
        return new BMW();
    }
}
