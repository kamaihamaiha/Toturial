package com.kk.sample.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kk.sample.R;

/**
*
* @Author: kk
* @Create Date: 18-9-11 下午10:22
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is MenuActivity.菜单的简单使用
*/
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //todo 重写此方法，然后把 /res/menu 里面的菜单布局文件 main.xml 创建到当前活动中
        getMenuInflater().inflate(R.menu.main, menu);
        //todo true 表示允许创建的菜单显示出来，如果返回 false 创建的菜单就无法显示
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //todo 重写此方法，处理菜单中控件的响应事件
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
    }
}
