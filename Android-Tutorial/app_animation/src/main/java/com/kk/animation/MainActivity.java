package com.kk.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_trans);

//        AnimUtil.startTrans(textView);
//        AnimUtil.startScale(textView);
//        AnimUtil.startAlpha(this, textView);
        AnimUtil.startAnimWithInterpolator(this,textView);


    }
}
