package com.kk.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.kk.ui.adapter.CustomPagerAdapter;
import com.kk.ui.utils.SystemUtil;

/**
*
* @Author: kk
* @Create Date: 19-3-5 下午10:37
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is ViewPagerActivity
*/
public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // SystemUtil.hideTitleBar(this);
      //  SystemUtil.setTitleBarTrans(this);
        SystemUtil.setTitleBarColor(this,this.getResources().getColor(R.color.title_bar_background));
        setContentView(R.layout.activity_viewpager);
        getSupportActionBar().hide();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }
}
