package com.kk.auto.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.kk.auto.MainActivity;

/**
*
* @Author: kk
* @Create Date: 19-1-13 下午12:28
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is 开机广播接收类
*/
public class BootCompleteReceiver extends BroadcastReceiver {
    private static final String TAG = "BootCompleteReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: -------------发现开机了！");
        //把程序启动起来
        Intent intentStart = new Intent(context, MainActivity.class);
        intentStart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentStart);

    }
}
