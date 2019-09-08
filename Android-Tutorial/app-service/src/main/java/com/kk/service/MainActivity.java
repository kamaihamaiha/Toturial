package com.kk.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private SpecialService.MyBinder myBinder = null;
    private EditText etData;
    private TextView tvDataFromService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.et_data);
        tvDataFromService = findViewById(R.id.tv_data_from_service);

        Button btnStartService = findViewById(R.id.btn_start_service);
        Button btnStopService = findViewById(R.id.btn_stop_service);
        Button btnBindService = findViewById(R.id.btn_bind_service);
        Button btnUnbindService = findViewById(R.id.btn_unbind_service);
        Button btnSyncData = findViewById(R.id.btn_sync_data);

        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnbindService.setOnClickListener(this);
        btnSyncData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                Intent intent = new Intent(MainActivity.this, SpecialService.class);
                intent.putExtra("data", "点击调用");
                startService(intent);
                break;
            case R.id.btn_stop_service:
                stopService(new Intent(MainActivity.this, SpecialService.class));
                break;
            case R.id.btn_bind_service:
                bindService(new Intent(MainActivity.this, SpecialService.class), this, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(this);
                break;
            case R.id.btn_sync_data:
                if (myBinder != null) {
                    myBinder.setData(etData.getText().toString().trim());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        myBinder = (SpecialService.MyBinder) service;
        myBinder.getService().setCallback(new SpecialService.Callback() {
            @Override
            public void onDataChange(final String data) {
                //todo 监听到服务数据变化了
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvDataFromService.setText(data);
                    }
                });
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
