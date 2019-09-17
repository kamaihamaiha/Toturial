package com.kk.test.junit;

import com.kk.test.TimeUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * 参数化测试
 */
@RunWith(Parameterized.class)
public class TimeUtilTest2 {
    private String time;

    public TimeUtilTest2(String time) {
        this.time = time;
    }

    @Parameterized.Parameters
    public static List<String> generateTimes(){
        //返回一组测试数据
        return  Arrays.asList(new String[]{
                "1999-01-01",
                "1999-01-01 12:10:19",
                "1999-01-01 12点10分19秒"
        });
    }

    @Test(expected = ParseException.class)
    public void time2StampTest() throws ParseException {
        TimeUtil.time2Stamp(time);
    }
}
