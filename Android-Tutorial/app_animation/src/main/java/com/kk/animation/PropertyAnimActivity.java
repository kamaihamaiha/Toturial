package com.kk.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kk.animation.widget.MyCircle2;

public class PropertyAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvProperty;
    private MyCircle2 myCircle2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_property_anim);
        myCircle2 = findViewById(R.id.myCircle2);

        tvProperty = findViewById(R.id.tv_property);

        findViewById(R.id.btn_start_value_anim_java).setOnClickListener(this);
        findViewById(R.id.btn_start_value_anim_xml).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_alpha_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_rotate_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_rotateX_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_rotateY_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_transX_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_transY_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_scaleX_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_scaleY_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_alpha_xml).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_transX_xml).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_rotate_xml).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_scaleX_xml).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_and_view).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_set_java).setOnClickListener(this);
        findViewById(R.id.btn_start_obj_anim_set_xml).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_value_anim_java:
                AnimUtil.startValueAnim(tvProperty);
                break;
            case R.id.btn_start_value_anim_xml:
                AnimUtil.startValueAnim(this, tvProperty);
                break;
            case R.id.btn_start_obj_anim_alpha_java:
                AnimUtil.startObjectAnimAlpha(tvProperty);
                break;
            case R.id.btn_start_obj_anim_rotate_java:
                AnimUtil.startObjectAnimRotate(tvProperty);
                break;
            case R.id.btn_start_obj_anim_rotateX_java:
                AnimUtil.startObjectAnimRotateX(tvProperty);
                break;
            case R.id.btn_start_obj_anim_rotateY_java:
                AnimUtil.startObjectAnimRotateY(tvProperty);
                break;
            case R.id.btn_start_obj_anim_scaleX_java:
                AnimUtil.startObjAnimScaleX(tvProperty);
                break;
            case R.id.btn_start_obj_anim_scaleY_java:
                AnimUtil.startObjAnimScaleY(tvProperty);
                break;
            case R.id.btn_start_obj_anim_transX_java:
                AnimUtil.startObjectAnimTransX(tvProperty);
                break;
            case R.id.btn_start_obj_anim_transY_java:
                AnimUtil.startObjectAnimTransY(tvProperty);
                break;
            case R.id.btn_start_obj_anim_alpha_xml:
                AnimUtil.startObjectAnimAlpha(this, tvProperty);
                break;
            case R.id.btn_start_obj_anim_transX_xml:
                AnimUtil.startObjectAnimTransX(this, tvProperty);
                break;
            case R.id.btn_start_obj_anim_rotate_xml:
                AnimUtil.startObjectAnimRotate(this, tvProperty);
                break;
            case R.id.btn_start_obj_anim_scaleX_xml:
                AnimUtil.startObjectAnimScaleX(this, tvProperty);
                break;
            case R.id.btn_start_obj_anim_and_view:
                AnimUtil.startMyCircle2Anim(myCircle2);
                break;
            case R.id.btn_start_obj_anim_set_java:
                AnimUtil.startObjAnimSet(tvProperty);
                break;
            case R.id.btn_start_obj_anim_set_xml:
                AnimUtil.startObjAnimSet(this,tvProperty);
                break;
        }
    }
}
