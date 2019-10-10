package com.kk.sample.intent;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kk.sample.R;

/**
*
* @Author: kk
* @Create Date: 18-9-12 下午11:16
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is HttpIntentActivity
 * 这是一个可以响应 tel 意图的活动
*/
public class TelIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_intent);
    }
}
