package com.example.jinyuanyuan1203.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jinyuanyuan1203.db.MyHelper;

import java.util.ArrayList;

public class MyDao {
    private MyHelper helper;
    private SQLiteDatabase db;


    public MyDao(Context context) {
        helper = new MyHelper(context);
        db = helper.getWritableDatabase();
    }

    public void selectAll(ArrayList<String> data) {
        ArrayList<String> datas = new ArrayList<>();
        db = helper.getWritableDatabase();
        Cursor cursor = db.query("news", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            datas.add(name);
        }
    }

    public void addData(String data) {
        db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", data);
        db.insert("news", null, cv);
    }

    public void del(){
        db = helper.getWritableDatabase();
        db.execSQL("delete from news");
    }
}
