package com.kk.broadcast2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
*
* @Author: kk
* @Create Date: 18-10-11 下午10:44
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is AnotherStandardBroadcastReceiver
 * 在 清单文件中，用了项目 app-broadcast 清单文件中 StandardBroadcastReceiver 的意图过滤 action。
 * 这样，当发送了指定的广播后，2个 app 程序都能收到这个广播
*/
public class AnotherOrderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context,"在 Another 中收到了有序广播,并且拦截了下来！",Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
