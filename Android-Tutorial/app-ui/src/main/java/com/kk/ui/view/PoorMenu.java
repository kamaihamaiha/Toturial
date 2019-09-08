package com.kk.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * @Author: kk
 * @Create Date: 19-3-17 下午8:00
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is PoorMenu
 * 自定义菜单，左右滑动
 */
public class PoorMenu extends RelativeLayout {
    private static final String TAG = PoorMenu.class.getSimpleName();
    private Context context;
    private FrameLayout leftMenu;
    private FrameLayout middleMenu;
    private FrameLayout rightMenu;
    private MoveListener moveListener;
    //往右移动最大值
    private int rightMoveMax;
    //往左移动最大值
    private int leftMoveMax;

    public PoorMenu(Context context) {
        super(context);
        initView(context);
    }

    public PoorMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    private void initView(Context context) {
        this.context = context;
        leftMenu = new FrameLayout(context);
        middleMenu = new FrameLayout(context);
        rightMenu = new FrameLayout(context);

        //设置菜单颜色
        leftMenu.setBackgroundColor(Color.rgb(140, 140, 140));
        middleMenu.setBackgroundColor(Color.rgb(100, 100, 100));
        rightMenu.setBackgroundColor(Color.rgb(40, 40, 40));

        //添加菜单到父控件
        addView(leftMenu);
        addView(middleMenu);
        addView(rightMenu);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        middleMenu.measure(widthMeasureSpec, heightMeasureSpec);
        //获取屏幕宽度和高度
        int screenWidth = MeasureSpec.getSize(widthMeasureSpec);

        //根据屏幕尺寸设置左右菜单尺寸
        int tempWidthMeasure = MeasureSpec.makeMeasureSpec((int) (screenWidth * 0.6f), MeasureSpec.EXACTLY);
        leftMenu.measure(tempWidthMeasure, heightMeasureSpec);
        rightMenu.measure(tempWidthMeasure, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        middleMenu.layout(l, t, r, b);
        rightMoveMax = leftMenu.getMeasuredWidth();
        leftMoveMax = rightMenu.getMeasuredWidth();
        leftMenu.layout(l - rightMoveMax, t, 0, b);
        rightMenu.layout(r, t, r + leftMoveMax, b);
    }

    private Point point = new Point();
    //超过 30px 认为是滑动
    private static final int DIS = 30;
    private boolean isLeftSlide = false;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                //每次按下屏幕就获取点的坐标
                point.x = (int) ev.getX();
                point.y = (int) ev.getY();
                return true;
            case MotionEvent.ACTION_UP:
                if (moveListener != null) {
                    moveListener.onStopMove();
                }
                isLeftSlide = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                //计算滑动距离
                int dxSignal = (int) (ev.getX() - point.x);
                int dX = Math.abs(dxSignal);
                int dY = (int) Math.abs(ev.getY() - point.y);
                if (dX >= DIS && dX > dY) {
                    //左右滑动
                    isLeftSlide = true;

                } else if (dY >= DIS && dY > dX) {
                    //上下滑动
                    isLeftSlide = false;
                }

                if (isLeftSlide) {
                    int curScroolX = getScrollX();
                    if (Math.abs(curScroolX) > leftMoveMax) {
                        //不要滑过界
                        if (dxSignal < 0) {
                            dxSignal = 0;
                        }
                    }else if ( Math.abs(curScroolX) > rightMoveMax){
                        if (dxSignal > 0) {
                            dxSignal = 0;
                        }
                    }
                    scrollBy(2, 0);
                    Log.d(TAG, "dispatchTouchEvent: scroolX= " + curScroolX);
                    Log.d(TAG, "dispatchTouchEvent: dxSignal= " + dxSignal);
                    point.x = (int) ev.getX();
                }

                if (moveListener != null) {
                    moveListener.onMove((int) ev.getX(), (int) ev.getY(), dX, dY);
                }
                return true;
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
