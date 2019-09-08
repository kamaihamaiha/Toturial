package com.kk.app_androidmk;

public class Hello {

    static {
        System.loadLibrary("hello");
    }

    public static native int greet();
}
