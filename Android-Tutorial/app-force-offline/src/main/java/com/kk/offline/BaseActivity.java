package com.kk.offline;

import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @Author: kk
 * @Create Date: 18-10-14 下午9:59
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is 活动的基类，在这里注册下线广播
 */
public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver forceOfflineReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollect.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        forceOfflineReceiver = new ForceOfflineReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kk.FORCE_OFFLINE_BROADCAST");
        registerReceiver(forceOfflineReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (forceOfflineReceiver != null) {
            unregisterReceiver(forceOfflineReceiver);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollect.removeActivity(this);
    }

}
