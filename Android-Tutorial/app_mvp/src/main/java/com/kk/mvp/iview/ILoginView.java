package com.kk.mvp.iview;

import com.kk.mvp.bean.LoginInfo;

public interface ILoginView {

    void onLoginSuccess(LoginInfo loginInfo);

    void onLoginFail(String msg);

}
