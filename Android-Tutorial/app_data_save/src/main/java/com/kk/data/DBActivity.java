package com.kk.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.kk.data.adapter.BookAdapter;
import com.kk.data.bean.Book;
import com.kk.data.callback.DBOperaListener;
import com.kk.data.db.SQLiteExecutor;
import com.kk.data.db.SQLiteExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张开旭
 * @Date: 2018/11/2
 * @E-mail: zhangkaixu@eyecool.cn
 * @Ltd: 山东眼神智能科技有限公司(www.facekey.cn)
 * @Address: 山东省济南市高新区齐鲁软件园B座508
 * @Des: this is 数据库操作界面
 */
public class DBActivity extends AppCompatActivity implements DBOperaListener {

    private Context mContext;
    private SQLiteExecutor dbExecutor;
    private SQLiteDatabase sqLiteDatabase;
    private BookAdapter bookAdapter;
    private int count;
    private List<Book> bookList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        getSupportActionBar().hide();

        mContext = this;

        RecyclerView recyclerViewBook = findViewById(R.id.recycler_table);
        bookList = new ArrayList<>();

        bookAdapter = new BookAdapter(bookList);
        bookAdapter.setDboPeraListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewBook.setLayoutManager(layoutManager);
        recyclerViewBook.setAdapter(bookAdapter);

        dbExecutor = new SQLiteExecutor(mContext, "Book.db", null, 2);
        sqLiteDatabase = dbExecutor.getReadableDatabase();

        //也可以直接用 SQL语句操作数据库。当然要熟悉语句才行
        String insertSQL = "insert into Book (name,author,pages,price) values(?,?,?,?)";
        sqLiteDatabase.execSQL(insertSQL,new String[]{"毛泽东语录","毛泽东","232","22.99"});

        /**
         * 创建数据库按钮监听
         */
        findViewById(R.id.btn_create_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dbExecutor != null) {
                    Toast.makeText(mContext, "数据库已经创建了！", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        /**
         * 清空数据库数据
         */
        findViewById(R.id.btn_clear_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sqLiteDatabase == null) {
                    sqLiteDatabase = dbExecutor.getWritableDatabase();
                }
                sqLiteDatabase.delete("Book", null, null);
                count = 0;
                queryDB(bookList);
            }
        });

        /**
         * 往数据库中添加一条记录按钮监听
         */

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sqLiteDatabase == null) {
                    sqLiteDatabase = dbExecutor.getWritableDatabase();
                }
                ContentValues values = new ContentValues();
                values.put("name", "书_" + count);
                values.put("author", "作者_" + count);
                values.put("pages", 100 + count);
                values.put("price", 48.99 + count);

                long insert = sqLiteDatabase.insert("Book", null, values);
                if (insert != -1) {
                    //todo 添加成功
                    Toast.makeText(mContext, "添加成功！", Toast.LENGTH_SHORT).show();
                } else {
                    //todo 添加失败
                    Toast.makeText(mContext, "添加失败！", Toast.LENGTH_SHORT).show();

                }
                count++;
            }
        });

        /**
         * 查询数据库
         */
        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryDB(bookList);
            }
        });

    }

    /**
     * 查询数据库操作
     *
     * @param bookList
     */
    private void queryDB(List<Book> bookList) {
        bookList.clear();
        sqLiteDatabase = dbExecutor.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                "Book",
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            do {
                //todo 遍历 Cursor 对象，取出数据并打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                bookList.add(new Book(name, author, pages, price));

            } while (cursor.moveToNext());
        }
        cursor.close();
        bookAdapter.notifyDataSetChanged();
    }

    /**
     * 根据书名查询数据，最多返回一个符合条件的对象
     * @param bookName
     * @return
     */
    private Book queryDB(String bookName) {
        Book book = null;
        bookList.clear();
        sqLiteDatabase = dbExecutor.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                "Book",
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            do {
                //todo 遍历 Cursor 对象，取出数据并打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));

                if (bookName.equals(name)) {
                    book = new Book(name, author, pages, price);
                    break;
                }


            } while (cursor.moveToNext());
        }
        cursor.close();
        return book;
    }

    @Override
    public void onUpdate(int position) {
        ContentValues values = new ContentValues();
        values.put("name", "new_name");
        String oldBookName = bookList.get(position).getName();

        sqLiteDatabase.update("Book", values, "name = ?", new String[]{oldBookName});
        queryDB(bookList);
    }

    @Override
    public void onDelete(int position) {
        String author = bookList.get(position).getAuthor();
        sqLiteDatabase.delete("Book","author = ?",new String[]{author});
        queryDB(bookList);
    }
}
