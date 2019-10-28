package com.design.pattern.FactoryMethod;

/**
 * @Author: kk
 * @Date: 2019-10-21 19:36
 * @Description:
 */
public class VolvoFactory extends Factory {
    @Override
    Car product() {
        return new Volvo();
    }
}
