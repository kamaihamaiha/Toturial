package com.kk.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * @Author: kk
 * @Create Date: 18-10-1 下午10:10
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is 网络变化广播监听
 * 1. 动态方式注册,必须在程序运行的时候才可以接收到广播
 * 2. 静态广播，实现开机启动
 */
public class MainActivity extends AppCompatActivity {

    private NetworkChangerReceiver receiver;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 注册广播接收者
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        receiver = new NetworkChangerReceiver();
        registerReceiver(receiver, filter);

        //TODO 发送标准广播，该广播是自定义的
        findViewById(R.id.btn_send_stand_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.kk.STAND_BROADCAST");
                sendBroadcast(intent);
            }
        });
        //TODO 发送有序广播，该广播是自定义的
        findViewById(R.id.btn_send_order_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.kk.ORDER_BROADCAST");
                sendOrderedBroadcast(intent,null);

            }
        });
        //todo 发送本地广播
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kk.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
        findViewById(R.id.btn_send_local_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.kk.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        //todo 发送广播，直接制定发送给 MyReceiver
        findViewById(R.id.btn_send_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyReceiver.class);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //TODO 注销广播接收者
        unregisterReceiver(receiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    /**
     * 网络变化广播接收者
     */
    class NetworkChangerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                //todo 连接到网络；
                Toast.makeText(context, "连接到网络！", Toast.LENGTH_SHORT).show();
            } else {
                //todo 没有连接到网络；
                Toast.makeText(context, "网络断开！", Toast.LENGTH_SHORT).show();

            }

        }
    }

    /**
     * 定义成内部类时，一定要定义成 static 的。
     */
    public static class StandardBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "收到标准广播！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 自定义有序广播
     */
    public static class OrderBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "收到有序广播！", Toast.LENGTH_SHORT).show();
            //TODO 如果优先级高的接收到了广播不想王下面传递了，那么可以终止这个广播
            abortBroadcast();

        }
    }

    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "收到本地广播！", Toast.LENGTH_SHORT).show();
        }
    }

}
