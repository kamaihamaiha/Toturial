package com.kk.permission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
*
* @Author: kk
* @Create Date: 19-3-12 下午10:52
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is MainActivity
 * 1. 给方法增加权限
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Love.love(this);
    }
}
