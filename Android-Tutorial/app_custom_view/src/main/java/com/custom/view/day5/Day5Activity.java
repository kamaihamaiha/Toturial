package com.custom.view.day5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.custom.view.R;

/**
 * @Author: kk
 * @Date: 2019-10-23 10:31
 * @Description: Path 贝塞尔曲线
 */
public class Day5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_day5);
    }
}
