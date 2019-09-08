package com.kk.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.kk.fragment.fragment.RightFragment;

/**
 * @Author: kk
 * @Create Date: 18-9-27 下午7:55
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is MainActivity 动态添加碎片
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button btnFragment = findViewById(R.id.btn_fragment);
        FrameLayout flContainer = findViewById(R.id.fl_container);

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_container, new RightFragment());
                //todo 这个方法用于模拟返回栈效果，按返回键，不至于退出 activity
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
