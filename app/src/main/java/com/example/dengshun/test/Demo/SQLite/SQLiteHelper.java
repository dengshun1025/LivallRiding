package com.example.dengshun.test.Demo.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author dengshun
 * Created by dengshun on 2016/7/25.
 */

public class SQLiteHelper extends SQLiteOpenHelper{

    public static final String sql = "create table users ("
            + "id integer primary key autoincrement,"
            + "username text,"
            + "password text)";
    Context mContext;
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
