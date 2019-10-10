package com.kk.content_provider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.kk.content_provider.adapter.ContactAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kk
 * @description 内容提供者:使用现有的内容提供器【如：通讯录】获取数据
 */
public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_READ_CONTACTS_PERMISSION_CODE = 100;
    ContactAdapter adapter;
    List<String[]> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ListView lvContact = findViewById(R.id.lv_contact);

        adapter = new ContactAdapter(this,R.layout.contact_item,contactsList);
        lvContact.setAdapter(adapter);

        //todo 检查权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_READ_CONTACTS_PERMISSION_CODE);
        } else {
            readContacts();
        }


    }

    /**
     * 读取通讯录
     */
    private void readContacts() {

        //1.创建 resolver 对象实例
        ContentResolver contentResolver = getContentResolver();
        //2.用系统提供的 URI 常量，调用 query 方法获取 cursor 对象，然后取出所有的数据。
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsList.add(new String[]{name,phoneNo});

            }
            adapter.notifyDataSetChanged();

            cursor.close();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_READ_CONTACTS_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts();
                } else {
                    //todo 提示用户拒绝了权限
                    Toast.makeText(this,"你拒绝了授予此权限！",Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
    }
}
