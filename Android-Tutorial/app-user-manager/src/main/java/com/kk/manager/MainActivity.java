package com.kk.manager;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.kk.fragment.BaseFragment;
import com.kk.fragment.DeviceInfoFragment;
import com.kk.fragment.RecordFragment;
import com.kk.fragment.RulerFragment;
import com.kk.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BaseFragment fragment;
    private RadioButton rbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        rbUser = findViewById(R.id.rb_user);
        RadioButton rbRuler = findViewById(R.id.rb_ruler);
        RadioButton rbAddUser = findViewById(R.id.rb_add_user);
        RadioButton rbUserRecord = findViewById(R.id.rb_record);
        RadioButton rbClientInfo = findViewById(R.id.rb_device_info);

        setBound(rbUser);
        setBound(rbRuler);
        setBound(rbAddUser, 100);
        setBound(rbUserRecord);
        setBound(rbClientInfo);

        rbUser.setOnClickListener(this);
        rbRuler.setOnClickListener(this);
        rbAddUser.setOnClickListener(this);
        rbUserRecord.setOnClickListener(this);
        rbClientInfo.setOnClickListener(this);

        initLoadUserInfo();
    }

    /**
     * 界面打开是，默认加载用户数据信息
     */
    private void initLoadUserInfo() {
        rbUser.setChecked(true);
        fragment = new UserFragment();
        showFragment();
    }

    private void setBound(RadioButton rb) {
        Drawable[] drawables = rb.getCompoundDrawables();
        drawables[1].setBounds(0, 0, 60, 60);
        rb.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    private void setBound(RadioButton rb, int size) {
        Drawable[] drawables = rb.getCompoundDrawables();
        drawables[1].setBounds(0, 0, size, size);
        rb.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_user:

                fragment = new UserFragment();
                break;
            case R.id.rb_ruler:
                fragment = new RulerFragment();

                break;
            case R.id.rb_add_user:

                break;
            case R.id.rb_record:
                fragment = new RecordFragment();

                break;
            case R.id.rb_device_info:
                fragment = new DeviceInfoFragment();

                break;

            default:
                break;
        }
        showFragment();
    }

    private void showFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_container, fragment);
        //todo 这个方法用于模拟返回栈效果，按返回键，不至于退出 activity
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
