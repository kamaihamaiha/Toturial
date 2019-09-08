package com.kk.offline;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
*
* @Author: kk
* @Create Date: 18-10-14 下午9:28
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is 管理所有创建的活动
*/
public class ActivityCollect {

    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    /**
     * 关闭所有的活动
     */
    public static void finishAll(){
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }



}
