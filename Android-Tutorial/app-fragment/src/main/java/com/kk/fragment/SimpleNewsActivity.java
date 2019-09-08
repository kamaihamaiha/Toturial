package com.kk.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kk.fragment.fragment.NewsFragment;

/**
*
* @Author: kk
* @Create Date: 18-9-27 下午8:40
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is SimpleNewsActivity 简易版的新闻应用，用 fragment 实现
 *
*/
public class SimpleNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getSupportActionBar().hide();

    }


}
