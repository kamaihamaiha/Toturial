package com.kk.mvp.callback;

import com.kk.mvp.bean.LoginInfo;

public interface LoginCallBack {

    void onSuccess(LoginInfo loginInfo);

    void onFail(String msg);
}
