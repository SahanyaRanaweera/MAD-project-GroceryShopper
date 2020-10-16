package com.example.groceryshopper.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelepr extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Shopper.db";
    public static final String TABLE_NAME = "Shop";

    public static final String COLS_1 = "ID_NO";
    public static final String COLS_2 = "ITEM_NO";
    public static final String COLS_3 = "ITEM_NAME";
    public static final String COLS_4 = "NAME";

    public DatabaseHelepr(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID_NO INTEGER PRIMARY KEY AUTOINCREMENT, ITEM_NO TEXT, ITEM_NAME TEXT, NAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
