package com.custom.view.day2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.custom.view.R;

/**
 * @Author: kk
 * @Date: 2019-10-21 09:32
 * @Description: 画布基本操作
 * 平移/缩放/旋转/侧切
 */
public class Day2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_day2);
    }

}
