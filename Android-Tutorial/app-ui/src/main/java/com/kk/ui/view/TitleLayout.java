package com.kk.ui.view;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.ui.ListViewActivity;
import com.kk.ui.R;
import com.kk.ui.RecyclerViewActivity;

/**
*
* @Author: kk
* @Create Date: 18-9-24 下午8:58
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is TitleLayout,自定义控件
*/
public class TitleLayout extends LinearLayout {

    private final Context mContext;
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_2, this);
        mContext = context;
        TextView tvTitle = findViewById(R.id.tv_comm_view);
        findViewById(R.id.btn_listView).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "ListView", Toast.LENGTH_SHORT).show();
                mContext.startActivity(new Intent(mContext, ListViewActivity.class));
            }
        });
        findViewById(R.id.btn_recyclerView).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "RecyclerView", Toast.LENGTH_SHORT).show();
                mContext.startActivity(new Intent(mContext, RecyclerViewActivity.class));
            }
        });
    }
}
