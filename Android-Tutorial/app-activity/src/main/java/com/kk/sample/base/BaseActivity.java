package com.kk.sample.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.kk.sample.ActivityCollector;

/**
*
* @Author: kk
* @Create Date: 18-9-17 下午8:25
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is BaseActivity.活动的基类
*/
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: -----------" + getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
