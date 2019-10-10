package com.kk.other;

import android.content.ComponentName;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_other_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_other_service).setOnClickListener(this);

        intent = new Intent();
        intent.setComponent(new ComponentName("com.kk.service","com.kk.service.SpecialService"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_other_service:
                startService(intent);
                break;
            case R.id.btn_stop_other_service:
                stopService(intent);
                break;

            default:
                break;
        }
    }
}
