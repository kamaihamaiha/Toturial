package com.kk.animation;

import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView textView;
    private Intent intent;
    private String[] nums = {"1", "2", "3", "4", "5"};
    private ListView listView;
    private ImageView ivFrameAnim;
    private boolean frameAnimFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_trans);
        listView = findViewById(R.id.lv);
        ivFrameAnim = findViewById(R.id.iv_frame_anim);

        intent = new Intent(MainActivity.this, SecondActivity.class);


        findViewById(R.id.btn_trans).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_interpolator).setOnClickListener(this);
        findViewById(R.id.btn_next_ui_fade_from_sys).setOnClickListener(this);
        findViewById(R.id.btn_next_ui_fade_from_customize).setOnClickListener(this);
        findViewById(R.id.btn_next_ui_slide_from_sys).setOnClickListener(this);
        findViewById(R.id.btn_next_ui_slide_from_customize).setOnClickListener(this);
        findViewById(R.id.btn_fragment_anim_sys).setOnClickListener(this);
        findViewById(R.id.btn_fragment_anim_customize).setOnClickListener(this);
        findViewById(R.id.btn_viewGroup_anim).setOnClickListener(this);
        findViewById(R.id.btn_frame_anim).setOnClickListener(this);
        findViewById(R.id.btn_property_anim).setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nums);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_trans:
                AnimUtil.startTrans(textView);
                break;
            case R.id.btn_scale:
                AnimUtil.startScale(textView);
                break;
            case R.id.btn_rotate:
                AnimUtil.startRotate(textView);
                break;
            case R.id.btn_alpha:
                AnimUtil.startAlpha(textView);
                break;
            case R.id.btn_interpolator:
                AnimUtil.startAnimWithInterpolator(this, textView);
                break;
            case R.id.btn_next_ui_fade_from_sys:
                MainActivity.this.startActivity(intent);
                //切换界面，动画效果： 淡入和淡出
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_next_ui_fade_from_customize:
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.my_fade_in, R.anim.my_fade_out);
                break;
            case R.id.btn_next_ui_slide_from_sys:
                MainActivity.this.startActivity(intent);
                //切换界面，动画效果： 滑入，滑出
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            case R.id.btn_next_ui_slide_from_customize:
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.my_out2left, R.anim.my_in_from_right);
                break;
            case R.id.btn_fragment_anim_sys:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                //Fragment 本身自带的动画切换效果: TRANSIT_FRAGMENT_CLOSE, TRANSIT_FRAGMENT_OPEN,TRANSIT_FRAGMENT_FADE...
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.replace(R.id.fl_container, new DemoFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.btn_fragment_anim_customize:
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
                //Fragment 本身自带的动画切换效果: TRANSIT_FRAGMENT_CLOSE, TRANSIT_FRAGMENT_OPEN,TRANSIT_FRAGMENT_FADE...
                transaction2.setCustomAnimations(R.anim.my_fade_in, R.anim.my_fade_out);
                transaction2.replace(R.id.fl_container, new DemoFragment());
                transaction2.addToBackStack(null);
                transaction2.commit();
                break;
            case R.id.btn_viewGroup_anim:
                AnimUtil.startAnimItem(MainActivity.this, listView);
                break;
            case R.id.btn_frame_anim:
                if (!frameAnimFlag) {
                    AnimUtil.startFrameAnim(ivFrameAnim);
                } else {
                    AnimUtil.stopFrameAnim(ivFrameAnim);
                }
                frameAnimFlag = !frameAnimFlag;
                break;
            case R.id.btn_property_anim:
                startActivity(new Intent(MainActivity.this,PropertyAnimActivity.class));
                break;
        }
    }
}
