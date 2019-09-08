package com.kk.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * @Author: 张开旭
 * @Date: 2018/11/2
 * @E-mail: zhangkaixu@eyecool.cn
 * @Ltd: 山东眼神智能科技有限公司(www.facekey.cn)
 * @Address: 山东省济南市高新区齐鲁软件园B座508
 * @Des: this is 自定义数据库打开帮助类继承 SQLiteOpenHelper
 */
public class SQLiteExecutor extends SQLiteOpenHelper {


    private static final String CREATE_BOOK = "create table book (" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)";
    private static final String CREATE_PEOPLE = "create table people (" +
            "id integer primary key autoincrement," +
            "name text," +
            "gender text," +
            "age integer)";
    private Context mContext;

    public SQLiteExecutor(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //todo 执行 SQL 语句，创建一个数据库表 book
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_PEOPLE);
        Toast.makeText(mContext, "创建数据库成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists People");
        onCreate(sqLiteDatabase);
    }
}
