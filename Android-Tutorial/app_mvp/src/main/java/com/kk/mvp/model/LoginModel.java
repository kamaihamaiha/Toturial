package com.kk.mvp.model;

import android.app.Activity;

import com.kk.mvp.bean.LoginInfo;
import com.kk.mvp.callback.LoginCallBack;
import com.kk.mvp.util.ExecutorUtil;

import java.util.Random;

/**
 * 登录的实际操作
 */
public class LoginModel {

    private Activity activity;

    public LoginModel(Activity activity) {
        this.activity = activity;
    }

    public void login(final LoginInfo loginInfo, final LoginCallBack loginCallBack){
        //模拟登录操作

        ExecutorUtil.executeSingle(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final boolean result = new Random().nextBoolean();

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result) {
                            loginCallBack.onSuccess(loginInfo);
                        } else {
                            loginCallBack.onFail("login error");
                        }
                    }
                });

            }
        });
    }
}
