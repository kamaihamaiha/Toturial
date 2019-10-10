package com.kk.sample.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kk.sample.Config;
import com.kk.sample.R;
import com.kk.sample.bean.Person;
import com.kk.sample.bean.User;

/**
 * @Author: kk
 * @Create Date: 18-9-11 下午10:24
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is IntentActivity. intent(意图)使用
 */
public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        getSupportActionBar().hide();

        findViewById(R.id.bt_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 跳转到菜单界面.这叫“显示意图”
                Intent intent = new Intent(IntentActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_skip_invisiable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 使用隐式意图开启一个活动。其中 com.kk.intent.second 在清单文件的 SecondActivity 标签
                //todo 的内部 action 标签已经注册了。
                //todo 注意：要同时匹配 <action> 和 <category> 才可以。且 <action> 只能有一个，<category>
                //todo 可以有多个
                Intent intent = new Intent("com.kk.intent.second");
                intent.addCategory("com.kk.intent.category.HELLO");
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_skip_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 使用隐式意图开启其他应用——浏览器或者可以响应 http 意图的活动
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_skip_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 使用隐式意图开启其他应用——电话或者可以响应 tel 意图的活动
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10010"));
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_skip_transmit_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo intent 可以在启动活动的时候传递数据
                String data = "拯救沧桑的艰巨任务就交给你了！";
                Intent intent = new Intent(IntentActivity.this, TransmitDataActivity.class);
                intent.putExtra(getString(R.string.intent_str_data_key), data);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_skip_transmit_data_bundle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo intent 可以在启动活动的时候传递数据，用 bundle 传递
                Intent intent = new Intent(IntentActivity.this, TransmitDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "中华人民共和国");
                bundle.putString("power", "中国共产党");
                bundle.putInt("age", 70);


                intent.putExtra("bundle_data", bundle);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_skip_transmit_data_obj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 开启活动，并且传递一个对象到下个界面
                Intent intent = new Intent(IntentActivity.this, TransmitDataActivity.class);
                intent.putExtra("obj", new User("赵四", 44, "男"));
                intent.putExtra("obj2",new Person("刘能",47,"男"));
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_skip_obtain_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 开启活动，并且从这个活动中获取数据
                Intent intent = new Intent(IntentActivity.this, ReturnDataActivity.class);
                startActivityForResult(intent, Config.RETURN_ACTIVITY_REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case Config.RETURN_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String resultData = data.getStringExtra(getString(R.string.intent_return_str_data_key));
                    Toast.makeText(this, resultData, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
