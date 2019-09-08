package com.kk.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
/**
*
* @Author: kk
* @Create Date: 19-3-12 下午10:52
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is Love
 * 调用该类的方法需要权限
*/
public class Love {
    private static final String PERMISSION_LOVE = "com.kk.permission.LOVE";
    private static final String TAG = "Love";

    public static void love(Context context){
        int checkResult = context.checkCallingOrSelfPermission(PERMISSION_LOVE);
        if (checkResult != PackageManager.PERMISSION_GRANTED) {
            //todo 抛出权限异常
            throw new SecurityException("执行 love() 方法，需要有 " + PERMISSION_LOVE + "权限！");
        }

        Log.d(TAG, "love: ...");
    }
}
