package com.kk.multi_thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static final int CORE_THREAD_SIZE = 3;
    private static final int MAX_THREAD_SIZE = 8;
    private static final long KEEP_ALIVE = 5;

    private static BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
    public static final Runnable TASK_1 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                System.out.println("execute task..." + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public static final Runnable TASK = new Runnable() {
        @Override
        public void run() {
            while (true) {
                System.out.println("execute task..." + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {

       /* new ThreadPoolExecutor(
                CORE_THREAD_SIZE,
                MAX_THREAD_SIZE,
                KEEP_ALIVE,
                TimeUnit.SECONDS,
                workQueue,

                );*/


        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("execute task..." + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            }
        };
        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("execute task..." + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            }
        };

        threadPool.execute(TASK);
        threadPool.execute(TASK_1);
        threadPool.execute(task2);
        threadPool.execute(task3);
    }
}
