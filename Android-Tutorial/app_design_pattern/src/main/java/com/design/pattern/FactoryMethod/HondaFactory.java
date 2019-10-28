package com.design.pattern.FactoryMethod;

/**
 * @Author: kk
 * @Date: 2019-10-21 19:33
 * @Description:
 */
public class HondaFactory extends Factory {
    @Override
    Car product() {
        return new Honda();
    }
}
