package com.kk.content_provider.provider;

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * @Author: kk
 * @Create Date: 18-12-26 下午10:58
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is 自定义内容提供者.
 * 任何一个应用程序都可以使用 ContentResolver 类来访问这个程序中的数据
 */
public class HappyProvider extends ContentProvider {


    private static final int DATA1_ALL = 0;
    private static final int DATA1_ITEM = 1;
    private static final int DATA2_ALL = 2;
    private static final int DATA2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.kk.provider", "data1", DATA1_ALL);
        uriMatcher.addURI("com.kk.provider", "data1/#", DATA1_ITEM);
        uriMatcher.addURI("com.kk.provider", "data2", DATA2_ALL);
        uriMatcher.addURI("com.kk.provider", "data2/#", DATA2_ITEM);
    }


    @Override
    public boolean onCreate() {
        //todo 通常会在这里完成对数据库的创建和升级操作，返回 true 表示内容提供器初始化成功。
        //todo 注意，只有当存在 ContentResolver 尝试访问我们程序中的数据时，内容提供器才会被初始化。
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //todo 从内容提供器查询数据。使用 uri 参数来确定查询哪张表， projectioon 参数用于确定查询哪些列，selection
        //todo 和 selectionArgs 参数用于约束查询哪些行，sortOrder 参与用于对结果进行排序，查询的结果放在 Cursor 对象中返回。

        switch (uriMatcher.match(uri)) {
            case DATA1_ALL:

                break;
            case DATA1_ITEM:

                break;
            case DATA2_ALL:

                break;
            case DATA2_ITEM:

                break;
            default:
                break;
        }

        return null;
    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        //todo 根据传入的内容 URI 来返回相应的 MIME 类型。
        //todo 格式：
        //1. 必须以 vnd 开头
        //2. 如果内容 URI 以路径结尾，则后接 android.cursor.dir/,如果内容 URI 以 id 结尾，则后接 android.cursor.item/。
        //3. 最后接上：vnd.<authority>.<path>。
        /**
         * 所以，对于 content://com.kk.provider.data1 这个内容 URI，它对应的 MIME 类型就可以写成：
         * vnd.android.cursor.dir/vnd.com.kk.provider.data1
         */

        switch (uriMatcher.match(uri)) {
            case DATA1_ALL:
                return "vnd.android.cursor.dir/vnd.com.kk.provider.data1";
            case DATA1_ITEM:
                return "vnd.android.cursor.item/vnd.com.kk.provider.data1";
            case DATA2_ALL:
                return "vnd.android.cursor.dir/vnd.com.kk.provider.data2";
            case DATA2_ITEM:
                return "vnd.android.cursor.item/vnd.com.kk.provider.data2";
            default:
                break;
        }

        return null;
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        //todo 向内容提供器添加一条数据。使用 uri 参数来确定要添加到的表，待添加的数据保存在 values 参数中，添加完成
        //todo 后返回一个用于表示这条新纪录的 URI。

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        //todo 更新内容提供器中已有的数据。使用 uri 参数来确定更新哪一张表中的数据，更新数据保存在 values 参数中，
        //todo selection 和 selectionArgs 参数用于约束更新哪些行，受影响的行数将作为返回值返回。
        return 0;
    }
}
