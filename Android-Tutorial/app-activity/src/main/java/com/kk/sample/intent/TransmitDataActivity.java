package com.kk.sample.intent;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.kk.sample.R;
import com.kk.sample.bean.Person;
import com.kk.sample.bean.User;

/**
 * @Author: kk
 * @Create Date: 18-9-13 上午7:13
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is TransmitDataActivity
 * 获取意图传递过来的数据
 */
public class TransmitDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmit_data);
        getSupportActionBar().hide();

        TextView tvData = findViewById(R.id.tv_data);
        TextView tvBundleData = findViewById(R.id.tv_bundle_data);
        TextView tvSerialzableData = findViewById(R.id.tv_serializable_data);
        TextView tvParcelableData = findViewById(R.id.tv_parcelable_data);

        //todo 获取开启此界面意图传递的数据
        Intent intent = getIntent();
        String data = intent.getStringExtra(getString(R.string.intent_str_data_key));
        tvData.setText(data == null ? "没有数据传递过来！" : data);

        //todo 获取开启此界面意图传递的数据-bundle
        //intent.getExtras(); 也可以...
        Bundle bundleData = intent.getBundleExtra("bundle_data");

        String bundleStr = null;
        if (bundleData == null) {
            bundleStr = "没有使用 bundle 传递值！";
        } else {

            bundleStr = "name:" + bundleData.getString("name") + "，"
                    + "power:" + bundleData.getString("power") + "，"
                    + "age:" + bundleData.getInt("age") + "年。";
        }

        tvBundleData.setText(bundleStr);

        //获取开启此界面意图传递的数据-对象[Serializable]序列化的
        Bundle bundle = intent.getExtras();

        String serializableStr = null;
        String serializableStr2 = null;
        User user = (User) bundle.get("obj");
        Person person = (Person) bundle.get("obj2");
        if (user != null) {
            serializableStr = String.format("name=%s,age=%d,gender=%s", user.getName(), user.getAge(), user.getGender());
        } else {
            serializableStr = "无";
        }

        tvSerialzableData.setText(serializableStr);

        if (person != null) {
            serializableStr2 = String.format("name=%s,age=%d,gender=%s", person.getName(), person.getAge(), person.getGender());
        } else {
            serializableStr2 = "无";
        }

        tvParcelableData.setText(serializableStr2);


    }
}
