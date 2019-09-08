package com.kk.ui.bean;

import com.kk.ui.R;

/**
*
* @Author: kk
* @Create Date: 19-3-5 下午10:46
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is ModelColor
*/
public enum ModelColor {

    RED(R.string.red,R.layout.view_red),
    BLUE(R.string.blue,R.layout.view_blue),
    GREEN(R.string.green,R.layout.view_green);

    private int mTitleResId;
    private int mLayoutResId;

    ModelColor(int mTitleResId, int mLayoutResId) {
        this.mTitleResId = mTitleResId;
        this.mLayoutResId = mLayoutResId;
    }

    public int getmTitleResId() {
        return mTitleResId;
    }

    public int getmLayoutResId() {
        return mLayoutResId;
    }
}
