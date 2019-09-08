package com.kk.auto.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kk.auto.MainActivity;
import com.kk.auto.util.SystemUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: kk
 * @Create Date: 19-1-13 下午6:44
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is 定时任务服务
 * 1.定时重启
 * 2.退出自启
 */
public class StartSelfService extends Service {

    private static final String TAG = "StartSelfService";
    private IBinder iBinder;
    private Timer timer;
    private TimerTask timerTask;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public void onCreate() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.i(TAG, "run: -------------时间服务：");
                boolean background = SystemUtil.isBackground(getApplicationContext());
                if (!background) {
                    //todo 处于前台，判断是否到了重启时间

                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    String dateFormat = sdf.format(new Date());
                    Log.d(TAG, "run: ---------------程序处于前台运行！\t" + dateFormat);

                    if (dateFormat.equals("19:42")) {
                        //todo 重启,一分钟后重启
                        try {
                            Thread.sleep(60000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        restartApp();
                    }

                } else {
                    //todo 处于后台，启动程序
                    Log.d(TAG, "run: ---------------程序处于后台运行！");
                    restartApp();

                }

            }
        };

        timer.schedule(timerTask, 1000, 10000);
    }

    private void restartApp() {
        stopSelf();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
