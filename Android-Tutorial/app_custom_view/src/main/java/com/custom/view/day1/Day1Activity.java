package com.custom.view.day1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.custom.view.R;

import java.util.ArrayList;
import java.util.List;

public class Day1Activity extends AppCompatActivity {

    private PieView pieView;
    private List<PieData> pieDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_day1);

        pieView = findViewById(R.id.pieView);

    }


    @Override
    protected void onStart() {
        super.onStart();
        pieDatas = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            pieDatas.add(new PieData("name_" + i, i));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pieView.setData(pieDatas);

            }
        }, 1000);

    }
}
