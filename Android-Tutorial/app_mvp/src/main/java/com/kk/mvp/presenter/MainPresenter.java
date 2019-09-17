package com.kk.mvp.presenter;

import android.app.Activity;

import com.kk.mvp.bean.LoginInfo;
import com.kk.mvp.callback.LoginCallBack;
import com.kk.mvp.iview.ILoginView;
import com.kk.mvp.model.LoginModel;

public class MainPresenter {
    private ILoginView iLoginView;
    private LoginModel loginModel;

    public MainPresenter(ILoginView iLoginView, Activity activity) {
        this.iLoginView = iLoginView;
        loginModel = new LoginModel(activity);
    }

    public void login(LoginInfo loginInfo){
        loginModel.login(loginInfo, new LoginCallBack() {
            @Override
            public void onSuccess(LoginInfo loginInfo) {
                iLoginView.onLoginSuccess(loginInfo);
            }

            @Override
            public void onFail(String msg) {
                iLoginView.onLoginFail(msg);
            }
        });
    }
}
