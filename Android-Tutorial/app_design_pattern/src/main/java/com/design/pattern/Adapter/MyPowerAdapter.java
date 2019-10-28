package com.design.pattern.Adapter;

/**
 * @Author: kk
 * @Date: 2019-10-23 17:40
 * @Description:
 */
public class MyPowerAdapter extends BasePowerAdapter implements OtherPower {
    @Override
    public int convert110V() {
        return 110;
    }

    @Override
    public int convert250V() {
        return 250;
    }
}
