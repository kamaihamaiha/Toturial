package com.kk.mvp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kk.mvp.bean.LoginInfo;
import com.kk.mvp.iview.ILoginView;
import com.kk.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private TextView tvInfo;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_data:
                clickLogin();
                break;
        }
    }


    @Override
    public void onLoginSuccess(LoginInfo loginInfo) {
        showLoginSuccess(loginInfo);
    }

    @Override
    public void onLoginFail(String msg) {
        showLoginFail(msg);
    }

    private void initData() {
        mainPresenter = new MainPresenter(this, MainActivity.this);
    }

    private void initView() {
        tvInfo = findViewById(R.id.tv_login_info);
        findViewById(R.id.btn_get_data).setOnClickListener(this);
    }

    private void clickLogin() {
        showWait();
        mainPresenter.login(new LoginInfo("admin", (int) System.currentTimeMillis() / 1000));
    }

    private void showWait() {
        tvInfo.setText("Loading...");
    }

    private void showLoginSuccess(LoginInfo loginInfo) {
        tvInfo.setText(loginInfo.getUserName() + "," + loginInfo.getAge());
    }

    private void showLoginFail(String msg) {
        tvInfo.setText(msg);
    }
}
