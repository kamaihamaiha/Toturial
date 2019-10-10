package com.kk.socket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ExecutorService threadPool;
    private Socket socket;
    private Handler mainHandler;
    private OutputStream outputStream;
    private BufferedReader bufferedReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化线程池
        threadPool = Executors.newCachedThreadPool();

        //实例化主线程
        mainHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 0:

                        break;
                    default:
                        break;
                }
            }
        };


    }


    public void connect() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    socket = new Socket("192.168.31.51", 2019);
                    boolean socketConnectState = socket.isConnected();
                    System.out.println("socket connect state: " + socketConnectState);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void disconnect(){
        try {
            outputStream.close();
            bufferedReader.close();
            socket.close();
            System.out.println("disconnect & socket status: " + socket.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void receiveMsg(){
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String response = bufferedReader.readLine();

            Message msg = Message.obtain();
            msg.what = 0;
            msg.obj = response;
            mainHandler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    outputStream = socket.getOutputStream();
                    //加上换行符号，才能让服务器端端 readline() 停止阻塞
                    outputStream.write((System.currentTimeMillis()+"\n").getBytes("utf-8"));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
