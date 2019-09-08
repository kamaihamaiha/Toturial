package com.kk.sample.lifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.kk.sample.R;
import com.kk.sample.base.BaseActivity;
import com.kk.sample.intent.IntentActivity;

public class MainActivity extends BaseActivity {
    private static final String TAG = "IntentActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NormalActivity.class));
            }
        });
        findViewById(R.id.btn_start_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
            }
        });
        findViewById(R.id.btn_start_web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://jikexueyuan.com")));
            }
        });
        findViewById(R.id.btn_start_intent_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IntentActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: -----------------onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: -----------------onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: -----------------onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: -----------------onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //todo 这个活动销毁后就杀死本应用
        Process.killProcess(Process.myPid());
        Log.d(TAG, "onDestroy: -----------------onDestroy!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: -----------------onRestart!");
    }

}
