package com.kk.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimUtil {

    public static void startTrans(Context context, View view) {
        Animation trans = AnimationUtils.loadAnimation(context, R.anim.my_trans_anim);
        view.startAnimation(trans);
    }

    public static void startTrans(View view) {
        Animation trans = new TranslateAnimation(0, 500, 0, 500);
        trans.setDuration(3000);
        view.startAnimation(trans);
    }

    public static void startScale(Context context, View view) {
        Animation scale = AnimationUtils.loadAnimation(context, R.anim.my_scale_anim);
        view.startAnimation(scale);
    }

    public static void startScale(View view) {
        Animation scale = new ScaleAnimation(0, 2, 0, 2, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(3000);
        view.startAnimation(scale);
    }

    public static void startRotate(Context context, View view) {
        Animation rotate = AnimationUtils.loadAnimation(context, R.anim.my_rotate_anim);
        view.startAnimation(rotate);
    }

    public static void startRotate(View view) {
       Animation rotate = new RotateAnimation(0,277,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
       rotate.setDuration(3000);
       view.startAnimation(rotate);
    }
}
