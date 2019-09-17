package com.kk.mvc.callback;

import com.kk.mvc.bean.LoginInfo;

public interface LoginCallBack {

    void loginSuccess(LoginInfo loginInfo);

    void loginFail(String errorMsg);
}
