package com.kk.mvc.model;

import android.app.Activity;
import android.view.View;

import com.kk.mvc.bean.LoginInfo;
import com.kk.mvc.callback.LoginCallBack;
import com.kk.mvc.util.ExecutorUtil;

import java.util.Random;

public class LoginModel {

    /**
     * 登录操作
     *
     * @param loginCallBack
     */
    public void login(final LoginCallBack loginCallBack, final Activity context) {
        ExecutorUtil.executeSingle(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final boolean result = new Random().nextBoolean();

                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result) {
                            loginCallBack.loginSuccess(new LoginInfo("admin", 22));
                        } else {
                            loginCallBack.loginFail("login error");
                        }
                    }
                });

            }
        });
    }


}
