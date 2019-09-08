package com.kk.auto.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * @Author: kk
 * @Create Date: 19-1-13 下午5:34
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is NetworkStateReceiver
 * 1.动态注册更好。因为网络不变化的时候，也会告诉我当前的网络状态
 */
public class NetworkStateReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkStateReceiver";
    private boolean mobileConnectState = false;
    private boolean wifiConnectState = false;
    private boolean etherConnectState = false;

    private NetStateListener netStateListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 网络状态发生变化");
        mobileConnectState = false;
        wifiConnectState = false;
        etherConnectState = false;
        //检测API是不是小于21，因为到了API21之后getNetworkInfo(int networkType)方法被弃用
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {

            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取ConnectivityManager对象对应的NetworkInfo对象
            //获取WIFI连接的信息
            NetworkInfo wifiNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            //获取移动数据连接的信息
            NetworkInfo dataNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            //获取以太网连接的信息
            NetworkInfo etherNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);

            wifiConnectState = wifiNetworkInfo.isConnected();
            mobileConnectState = dataNetworkInfo.isConnected();
            etherConnectState = etherNetworkInfo.isConnected();


        } else {
            //这里的就不写了，前面有写，大同小异
            System.out.println("API level 大于21");
            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取所有网络连接的信息
            Network[] networks = connMgr.getAllNetworks();
            //用于存放网络连接信息
            StringBuilder sb = new StringBuilder();
            //通过循环将网络信息逐个取出来
            for (int i = 0; i < networks.length; i++) {
                //获取ConnectivityManager对象对应的NetworkInfo对象
                NetworkInfo networkInfo = connMgr.getNetworkInfo(networks[i]);
                if ("Ethernet".equals(networkInfo.getTypeName())) {
                    etherConnectState = networkInfo.isConnected();
                    Log.d(TAG, "onReceive: 以太网状态： " + etherConnectState);
                }
                if ("WIFI".equals(networkInfo.getTypeName().toUpperCase())) {
                    wifiConnectState = networkInfo.isConnected();
                }
                if ("MOBILE".equals(networkInfo.getTypeName().toUpperCase())) {
                    mobileConnectState = networkInfo.isConnected();
                }
            }


        }

        if (netStateListener != null) {
            if (etherConnectState) {
                netStateListener.ethernet();
            }
            if (wifiConnectState) {
                netStateListener.wifi();
            }
            if (mobileConnectState) {
                netStateListener.lte();
            }

            if (!etherConnectState && !wifiConnectState && !mobileConnectState) {
                netStateListener.noNet();
            }
        }
    }

    public interface NetStateListener {
        /**
         * 没有连接网络
         */
        void noNet();

        /**
         * 以太网已连接
         */
        void ethernet();

        /**
         * WIFI已连接
         */
        void wifi();

        /**
         * 4G网络已连接
         */
        void lte();
    }


    public void setNetStateListener(NetStateListener netStateListener) {
        this.netStateListener = netStateListener;
    }
}
