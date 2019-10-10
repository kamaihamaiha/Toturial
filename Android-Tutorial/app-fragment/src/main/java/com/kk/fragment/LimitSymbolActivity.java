package com.kk.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
*
* @Author: kk
* @Create Date: 18-9-27 下午7:56
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is LimitSymbolActivity 使用限定符。
 * 注意： xml 静态引用自定义 fragment，一定要给个 id。
 * 该活动引用的 activity_limit_symbol 有 3 个。 程序根据运行的设备分辨率加载 不同的布局。
 * layout/          默认情况加载
 * layout-large/    认为是 large 设备时加载
 * layout-sw300dp/  屏幕宽度大于 300dp 时加载
*/
public class LimitSymbolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit_symbol);
        getSupportActionBar().hide();
    }
}
