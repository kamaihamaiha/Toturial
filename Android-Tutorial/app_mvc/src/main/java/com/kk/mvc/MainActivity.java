package com.kk.mvc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kk.mvc.bean.LoginInfo;
import com.kk.mvc.callback.LoginCallBack;
import com.kk.mvc.model.LoginModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInfo;
    private LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tv_login_info);
        loginModel = new LoginModel();
        findViewById(R.id.btn_get_data).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_data:
                clickLogin();
                break;
            default:
                break;
        }
    }

    /**
     * 点击登录操作
     */
    private void clickLogin() {
        loginModel.login(new LoginCallBack() {
            @Override
            public void loginSuccess(LoginInfo loginInfo) {
                showLoginSuccess(loginInfo);
            }

            @Override
            public void loginFail(String errorMsg) {
                showLoginFail(errorMsg);
            }
        }, MainActivity.this);
        showLoginWait();
    }

    private void showLoginSuccess(LoginInfo loginInfo) {
        tvInfo.setText(loginInfo.getUserName() + "," + loginInfo.getAge());
    }

    private void showLoginFail(String msg) {
        tvInfo.setText(msg);
    }

    private void showLoginWait() {
        tvInfo.setText("loading...");
    }
}
