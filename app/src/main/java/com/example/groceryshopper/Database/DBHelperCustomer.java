package com.example.groceryshopper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.groceryshopper.Model.Customer;
import com.example.groceryshopper.Model.DealsList;

import java.util.ArrayList;
import java.util.List;

public class DBHelperCustomer extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GroceryShopper2.db";
    public DBHelperCustomer(Context context) {
        super(context, DATABASE_NAME, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+UsersMaster.Customers.TBL_NAME+" ("+
                        UsersMaster.Customers._ID+" INTEGER PRIMARY KEY,"+
                        UsersMaster.Customers.COL_NAME_FULL_NAME+" TEXT,"+
                        UsersMaster.Customers.COL_NAME_ADDRESS+" TEXT,"+
                        UsersMaster.Customers.COL_NAME_HOME_NO+" TEXT,"+
                        UsersMaster.Customers.COL_NAME_MOBILE+" TEXT,"+
                        UsersMaster.Customers.COL_NAME_EMAIL+" TEXT,"+
                        UsersMaster.Customers.COL_NAME_USERNAME+" TEXT,"+
                        UsersMaster.Customers.COL_NAME_PASSWORD+" TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addCustomer(Customer cus1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UsersMaster.Customers.COL_NAME_FULL_NAME, cus1.getFullName());
        values.put(UsersMaster.Customers.COL_NAME_ADDRESS, cus1.getAddress());
        values.put(UsersMaster.Customers.COL_NAME_HOME_NO, cus1.getHomeNo());
        values.put(UsersMaster.Customers.COL_NAME_MOBILE, cus1.getMobile());
        values.put(UsersMaster.Customers.COL_NAME_EMAIL, cus1.getEmail());
        values.put(UsersMaster.Customers.COL_NAME_USERNAME, cus1.getUsername());
        values.put(UsersMaster.Customers.COL_NAME_PASSWORD, cus1.getPassword());
        long rowId = db.insert(UsersMaster.Customers.TBL_NAME,null,values);
        return rowId;
    }


    public boolean getLogin(String uName, String pass){
        boolean success = false;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                UsersMaster.Customers.TBL_NAME,
                new String[] {UsersMaster.Customers._ID},
                UsersMaster.Customers.COL_NAME_USERNAME+"=?"+" AND "+UsersMaster.Customers.COL_NAME_PASSWORD+"=?",
                new String[] {uName,pass},
                null,
                null,
                null
        );
        int count=cursor.getCount();
        if (count>0){
                success = true;
        }

        return success;
    }


}
