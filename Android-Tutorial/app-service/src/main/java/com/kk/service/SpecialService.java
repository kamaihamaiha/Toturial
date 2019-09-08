package com.kk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @Author: kk
 * @Create Date: 19-3-9 下午10:35
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is SpecialService
 * 服务，可与 activity 进行双向通信
 */
public class SpecialService extends Service {
    private static final String TAG = SpecialService.class.getSimpleName();
    private boolean running = false;
    private String data;
    private Callback callback;

    public SpecialService() {
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }

    public class MyBinder extends Binder {

        /**
         * 外部传递数据给服务
         *
         * @param data
         */
        public void setData(String data) {
            SpecialService.this.data = data;
        }

        /**
         * 对外提供获取服务实例的方法
         *
         * @return
         */
        public SpecialService getService() {
            return SpecialService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        running = true;
        Log.d(TAG, "onCreate: 服务创建了×××××××××××××××××××");
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (running) {

                    try {
                        i++;
                        String strData = i + ":" + data;
                        Log.d(TAG, "run: 特殊服务正在运行...\n数据：" + data);
                        if (callback != null) {
                            callback.onDataChange(strData);
                        }
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataStr = intent.getStringExtra("data");
        Log.d(TAG, "onStartCommand: 调用一次服务... " + dataStr);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
        Log.d(TAG, "onDestroy: 特殊服务停止了...");
    }

    /**
     * 服务的回调类
     */
    public static interface Callback {

        void onDataChange(String data);
    }
}
