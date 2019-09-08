package com.kk.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kk.ui.view.MoveListener;
import com.kk.ui.view.PoorMenu;

public class SlideMenuActy extends AppCompatActivity implements MoveListener {

    private TextView tvMenuMoveInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_menu);
        getSupportActionBar().hide();

        RelativeLayout rlContainer = findViewById(R.id.rl_menu_container);
        PoorMenu poorMenu = new PoorMenu(this);
        poorMenu.setMoveListener(this);
        rlContainer.addView(poorMenu, 1080, 1920);


        tvMenuMoveInfo = findViewById(R.id.tv_move_info);
        tvMenuMoveInfo.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onMove(int x, int y, int dx, int dy) {

        showInfo(x, y, dx, dy);
    }


    @Override
    public void onStopMove() {
        hideInfo();
    }

    private void hideInfo() {
        tvMenuMoveInfo.setText("");
        tvMenuMoveInfo.setVisibility(View.INVISIBLE);
    }

    private void showInfo(int x, int y, int dx, int dy) {
        String info = "(" + x + "," + y + ")" + "\n" + "水平移动：" + dx;
        tvMenuMoveInfo.setVisibility(View.VISIBLE);
        tvMenuMoveInfo.setText(info);
    }
}
