package com.kk.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kk.mvvm.bean.LoginInfo;
import com.kk.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private LoginInfo loginInfo;
    private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loginInfo = new LoginInfo("admin",22);

        viewDataBinding.setLoginInfo(loginInfo);
        viewDataBinding.setActivity(this);

    }

    public void onClick(View view){
        loginInfo.setAge((int) System.currentTimeMillis());
//        viewDataBinding.setLoginInfo(loginInfo);
    }
}
