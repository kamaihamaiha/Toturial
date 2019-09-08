package com.kk.offline;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
/**
*
* @Author: kk
* @Create Date: 18-10-14 下午9:51
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is 强制下线广播
*/
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("下线");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setMessage("长时间未登录，你需要重新登录！");
        dialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollect.finishAll();
                Intent intent1 = new Intent(context, LoginActivity.class);
                context.startActivity(intent1);
            }
        });
        dialogBuilder.show();

    }
}
