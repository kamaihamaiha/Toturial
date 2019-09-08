package com.kk.offline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @Author: kk
 * @Create Date: 18-10-14 下午10:08
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is 登录界面
 */
public class LoginActivity extends BaseActivity {

    private boolean hasUsername;
    private boolean hasPWD;
    private Context mContext;
    private EditText etUserName;
    private EditText etPWD;
    private String inputUserName;
    private String inputPWD;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        mContext = this;

        etUserName = findViewById(R.id.et_username);
        etPWD = findViewById(R.id.et_pwd);



        btnLogin = findViewById(R.id.btn_login);


        hasUsername = false;
        hasPWD = false;

        etUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    hasUsername = true;
                } else {
                    hasUsername = false;
                }
                changeBtnState();
            }
        });

        etPWD.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    hasPWD = true;
                } else {
                    hasPWD = false;
                }

                changeBtnState();
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputUserName = etUserName.getText().toString().trim();
                inputPWD = etPWD.getText().toString().trim();
                if (TextUtils.isEmpty(inputUserName) || TextUtils.isEmpty(inputPWD)) {
                    Toast.makeText(mContext, "用户名和密码不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputUserName.equals("admin") && inputPWD.equals("123456")) {
                    //todo 操作成功
                    startActivity(new Intent(mContext, MainActivity.class));
                } else {
                    Toast.makeText(mContext, "用户名或密码错误!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLogin.setClickable(false);


    }

    private void changeBtnState() {
        if (hasUsername && hasPWD) {
            btnLogin.setClickable(true);
            btnLogin.setBackground(getDrawable(R.drawable.rectangle_blue));
        } else {
            btnLogin.setClickable(false);
            btnLogin.setBackground(getDrawable(R.drawable.rectangle_grey));
        }
    }
}
