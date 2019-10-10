package com.kk.permission;

import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.LOVE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        }
    }
}
