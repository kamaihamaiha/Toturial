package com.kk.auto;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kk.auto.broadcast.NetworkStateReceiver;
/**
*
* @Author: kk
* @Create Date: 19-1-13 下午4:17
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is MainActivity
*/
public class MainActivity extends AppCompatActivity implements NetworkStateReceiver.NetStateListener {
    private static final String TAG = "MainActivity";
    private NetworkStateReceiver netWorkStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



    }


    @Override
    protected void onResume() {
        if (netWorkStateReceiver == null) {
            netWorkStateReceiver = new NetworkStateReceiver();
            netWorkStateReceiver.setNetStateListener(this);
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkStateReceiver, filter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (netWorkStateReceiver != null) {
            unregisterReceiver(netWorkStateReceiver);
        }
        super.onPause();
    }


    @Override
    public void noNet() {
        Log.d(TAG, "noNet: ");
    }

    @Override
    public void ethernet() {
        Log.d(TAG, "ethernet: ");
    }

    @Override
    public void wifi() {
        Log.d(TAG, "wifi: ");
    }

    @Override
    public void lte() {
        Log.d(TAG, "lte: ");
    }
}
