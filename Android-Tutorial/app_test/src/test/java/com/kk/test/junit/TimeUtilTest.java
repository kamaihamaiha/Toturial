package com.kk.test.junit;

import com.kk.test.TimeUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

//最基本的用法
public class TimeUtilTest {

    private static final String TIME = "2019-09-17 20:13:53";
    private static final long STAMP = 1568722433000L;

    @Before
    public void start() {
        System.out.println("Test starting...");
    }

    @After
    public void end() {
        System.out.println("Test end.");
    }

    @Test
    public void stamp2TimeTest() {
        Assert.assertEquals(TIME, TimeUtil.stamp2Time(STAMP));
    }

    @Test(expected = ParseException.class)
    public void time2StampTest() throws ParseException {
        Assert.assertEquals(STAMP, TimeUtil.time2Stamp(TIME));
    }

}
