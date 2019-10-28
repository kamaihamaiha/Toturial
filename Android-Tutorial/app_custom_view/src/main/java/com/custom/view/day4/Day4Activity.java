package com.custom.view.day4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.custom.view.R;

/**
 * @Author: kk
 * @Date: 2019-10-23 10:31
 * @Description: Path 基本操作
 * 1- 画线
 * 2- 画矩形
 * 3- Path 叠加
 */
public class Day4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_day4);
    }
}
