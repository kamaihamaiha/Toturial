package com.kk.multi_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler workHandler;
    private Handler mainHandler;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tv_info);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        //创建 handlerThread
        HandlerThread mHandlerThread = new HandlerThread("handlerThread");


        mHandlerThread.start();

        mainHandler = new Handler();
        //工作线程，执行耗时操作
        workHandler = new Handler(mHandlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1:
                    case 2:
                    case 3:
                        operaAndUpdataUI(msg.what);
                    default:
                        break;

                }
            }
        };

    }

    private void operaAndUpdataUI(int x) {
        haveASleep(1000 * x);
        final int flag = x;
        //在主线程更新 UI
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                tvInfo.setText("btn" +
                        flag +
                        " clicked!");
            }
        });
    }

    private void haveASleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                send(1);
                break;
            case R.id.btn2:
                send(2);
                break;
            case R.id.btn3:
                send(3);
                break;
            default:
                break;
        }
    }

    private void send(int tag) {
        Message msg = Message.obtain();
        msg.what = tag;
        workHandler.sendMessage(msg);
    }
}
