package com.kk.rx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);


        callRxJava();
    }

    /**
     * 调用,简单示例
     */
    private void callRxJava() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; i < 10; i++) {
                    emitter.onNext(i);
                    Thread.sleep(1000);
                }
                emitter.onComplete();
            }
        });


        Observer<Integer> observer = new Observer<Integer>() {
            // 通过复写对应方法来 响应 被观察者
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "start subscribe connecting...");
            }

            // 默认最先调用复写的 onSubscribe（）
            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "Next event" + value + " response");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error event response");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Complete event response");
            }
        };


        observable.subscribe(observer);
    }

    /**
     * 链式调用
     */
    public void callRxJava2() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 0; i < 10; i++) {
                    emitter.onNext(i + "");
                    Thread.sleep(1000);
                }
                emitter.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
