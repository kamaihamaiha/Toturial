package com.kk.mvp.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorUtil {

    private static ExecutorService FIX_EXECUTORS = Executors.newCachedThreadPool();
    private static ExecutorService SINGLE_EXECUTORS = Executors.newSingleThreadExecutor();

    public static void execute(Runnable runnable){
        FIX_EXECUTORS.execute(runnable);
    }

    public static void executeSingle(Runnable runnable){
        SINGLE_EXECUTORS.execute(runnable);
    }
}
