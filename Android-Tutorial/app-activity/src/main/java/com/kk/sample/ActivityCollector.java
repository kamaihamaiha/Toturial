package com.kk.sample;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
*
* @Author: kk
* @Create Date: 18-9-16 下午11:33
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is ActivityCollector
 * 活动的管理类，可以随时随地的退出某个活动
*/
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
