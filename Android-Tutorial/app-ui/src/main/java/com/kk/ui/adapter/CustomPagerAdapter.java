package com.kk.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.ui.bean.ModelColor;

/**
*
* @Author: kk
* @Create Date: 19-3-5 下午10:42
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is 自定义 viewpager 适配器
*/
public class CustomPagerAdapter extends PagerAdapter {
    private Context context;

    public CustomPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ModelColor.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ModelColor modelColor = ModelColor.values()[position];
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) layoutInflater.inflate(modelColor.getmLayoutResId(),
                container,false);
        container.addView(layout);
        return layout;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        ModelColor modelColor = ModelColor.values()[position];
        return context.getString(modelColor.getmTitleResId());
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
