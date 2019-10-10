package com.kk.sample.intent;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kk.sample.R;

/**
*
* @Author: kk
* @Create Date: 18-9-13 上午7:13
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is ReturnDataActivity
 * 按下返回键后，把数据返回给打开此界面的活动
*/
public class ReturnDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_data);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ReturnDataActivity.this, IntentActivity.class);
        intent.putExtra(getString(R.string.intent_return_str_data_key),"要什么，我都给你！");
        setResult(RESULT_OK,intent);
        finish();
    }
}
