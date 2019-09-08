package com.kk.offline;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        findViewById(R.id.btn_force_offline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 点击下下后，就发送一条下线的广播
                Intent intent = new Intent("com.kk.FORCE_OFFLINE_BROADCAST");
                sendBroadcast(intent);

            }
        });
    }
}
