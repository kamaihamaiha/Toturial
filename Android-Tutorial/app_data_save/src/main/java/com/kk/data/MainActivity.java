package com.kk.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author kk
 * @date 2018-11-2 周五
 */
public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private EditText etAccount;
    private String editFileName = "edit.txt";
    private Context mContext;
    private EditText etUserName;
    private EditText etUserPwd;
    private CheckBox cbRememberPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mContext = this;
        etAccount = findViewById(R.id.et_account);

        //todo 读取先前保存到文件的数据
        String inputText = readFile(editFileName);

        if (!TextUtils.isEmpty(inputText)) {
            etAccount.setText(inputText);
            //todo 将光标移动到末尾
            etAccount.setSelection(inputText.length());
        }

        findViewById(R.id.btn_save_file_overlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 点击就保存到文件[覆盖]。
                saveFile("data_overlay.txt", null, true);

            }
        });
        findViewById(R.id.btn_save_file_append).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 点击就保存到文件[添加]。
                saveFile("data_append.txt", null, false);

            }
        });

        //todo SharedPreferences 保存数据。获取有三种方式
        //1. Context 类中， getSharedPreferences()

        //2. Activity 类中，getPreferences()

        //3. PreferenceManager 类中，getDefaultSharedPreference()

        findViewById(R.id.btn_save_sp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MODE_PRIVATE 只有当前的程序才可以对这个文件进行读写
                // MODE_MULTI_PROCESS 多个进程可以对用一个 SharedPreferences 文件进行读写
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Kk");
                editor.putInt("age", 18);
                editor.putBoolean("happy", true);
                editor.commit();
            }
        });

        findViewById(R.id.btn_read_sp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "");
                int age = sharedPreferences.getInt("age", 0);
                boolean happy = sharedPreferences.getBoolean("happy", false);

                Toast.makeText(
                        mContext,
                        "name:\t" + name + "\nage:\t" + age + "\nhappy:\t" + happy,
                        Toast.LENGTH_SHORT).show();

            }
        });

        //todo 实现记住密码功能,实际在保存的时候为了完全要用加密算法来保存密码
        etUserName = findViewById(R.id.et_user_name);
        etUserPwd = findViewById(R.id.et_user_pwd);
        cbRememberPwd = findViewById(R.id.cb_remember_pwd);

        final SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        boolean isRemember = sharedPreferences.getBoolean("remember_password", false);
        if (isRemember) {
            //todo 如果是记住了密码了，就把用户名和密码都设置到文本输入框中
            String userName = sharedPreferences.getString("account", "");
            String userPwd = sharedPreferences.getString("password", "");

            etUserName.setText(userName);
            etUserPwd.setText(userPwd);
            cbRememberPwd.setChecked(true);
        }

        //todo 登录操作
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 1.检查用户名和密码；2.检查是否记住了密码，如果记住了就把是否记住密码保存下来
                if (TextUtils.isEmpty(etUserName.getText().toString().trim())
                        || TextUtils.isEmpty(etUserPwd.getText().toString().trim())) {
                    Toast.makeText(mContext, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cbRememberPwd.isChecked()) {
                    sharedPreferences.edit().putBoolean("remember_password", true).commit();
                } else {
                    sharedPreferences.edit().putBoolean("remember_password", false).commit();
                }
                //正确的用户名和密码是 admin 123456

                String inputAccount = etUserName.getText().toString().trim();
                String inputPwd = etUserPwd.getText().toString().trim();
                sharedPreferences.edit().putString("account", inputAccount).commit();
                sharedPreferences.edit().putString("password", inputPwd).commit();

                if (!inputAccount.equals("admin")) {
                    Toast.makeText(mContext, "用户名错误！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!inputPwd.equals("123456")) {
                    Toast.makeText(mContext, "密码错误！", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(mContext,"登录成功！",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this,DBActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //todo 界面销毁前，把文本框输入的内容保存到文件中
        String input = etAccount.getText().toString();

        saveFile(editFileName, input, true);
    }

    /**
     * 保存文件
     *
     * @param fileName
     * @param isOverlay 写数据到文件，是否是覆盖内容模式
     */
    private void saveFile(String fileName, String data, boolean isOverlay) {
        FileOutputStream fos = null;
        BufferedWriter bufferedWriter = null;
        try {
            count++;
            //todo 该文件在 /data/data/<packagename>/files/ 下
            fos = openFileOutput(fileName, isOverlay ? Context.MODE_PRIVATE : Context.MODE_APPEND);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
            if (data == null) {
                bufferedWriter.write(count + "\n");
            } else {
                bufferedWriter.write(data + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取 /data/data/<packagename>/files/ 下的文件
     *
     * @param fileName
     * @return
     */
    public String readFile(String fileName) {
        FileInputStream fis = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            fis = openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
