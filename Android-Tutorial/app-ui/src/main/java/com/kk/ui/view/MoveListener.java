package com.kk.ui.view;

/**
 * @Author: kk
 * @Create Date: 19-3-17 下午8:46
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is MoveListener
 * 自定义空间手指滑动事件监听，给 activity 使用
 */

public interface MoveListener {

    /**
     * 在移动
     * @param x x坐标
     * @param y y坐标
     * @param dx x移动距离
     * @param dy y移动距离
     */
    void onMove(int x, int y, int dx, int dy);

    void onStopMove();
}
