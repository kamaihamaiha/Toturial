package com.kk.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    private static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    public static String stamp2Time() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME, Locale.CHINA);
        String format = sdf.format(new Date(System.currentTimeMillis()));
        return format;
    }

    public static String stamp2Time(long stamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME, Locale.CHINA);
        String format = sdf.format(new Date(stamp));
        return format;
    }

    public static long time2Stamp(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME, Locale.CHINA);
        Date date = sdf.parse(time);
        return date.getTime();
    }

}
