package com.custom.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.custom.view.day1.Day1Activity;
import com.custom.view.day2.Day2Activity;
import com.custom.view.day3.Day3Activity;
import com.custom.view.day4.Day4Activity;
import com.custom.view.day5.Day5Activity;

/**
 * @Author: kk
 * @Date: 2019-10-21 09:24
 * @Description:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_day1).setOnClickListener(this);
        findViewById(R.id.btn_day2).setOnClickListener(this);
        findViewById(R.id.btn_day3).setOnClickListener(this);
        findViewById(R.id.btn_day4).setOnClickListener(this);
        findViewById(R.id.btn_day5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_day1:
                startActivity(new Intent(this, Day1Activity.class));
                break;
            case R.id.btn_day2:
                startActivity(new Intent(this, Day2Activity.class));
                break;
            case R.id.btn_day3:
                startActivity(new Intent(this, Day3Activity.class));
                break;
            case R.id.btn_day4:
                startActivity(new Intent(this, Day4Activity.class));
                break;
            case R.id.btn_day5:
                startActivity(new Intent(this, Day5Activity.class));
                break;
            default:
                break;
        }
    }
}
