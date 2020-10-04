package com.example.groceryshopper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.groceryshopper.Model.CartModel;

public class DBHelperOrder extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GroceryShopper2.db";

    public DBHelperOrder(Context context) {
        super(context, DATABASE_NAME, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES2 =
                "CREATE TABLE IF NOT EXISTS "+ OrdersMaster.Orders.TBL_NAME_4+" ("+
                        OrdersMaster.Orders._ID+" INTEGER PRIMARY KEY,"+
                        OrdersMaster.Orders.COL_NAME_ITEM_NAME+" TEXT,"+
                        OrdersMaster.Orders.COL_NAME_ITEM_PRICE+" TEXT,"+
                        OrdersMaster.Orders.COL_NAME_ITEM_QUANTITY+" TEXT,"+
                        OrdersMaster.Orders.COL_NAME_USER_NAME+" TEXT,"+
                        OrdersMaster.Orders.COL_NAME_STATUS+" TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES2);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ShopCartMaster.ShopCartItems.TBL_NAME_3);
        onCreate(db);
    }

    public void addToOrders(CartModel[] c){
        SQLiteDatabase db = this.getWritableDatabase();
        for(int i = 0 ; i < c.length ; i++) {
            ContentValues values = new ContentValues();
            values.put(OrdersMaster.Orders.COL_NAME_ITEM_NAME, c[i].getItemName());
            values.put(OrdersMaster.Orders.COL_NAME_ITEM_PRICE, c[i].getPrice());
            values.put(OrdersMaster.Orders.COL_NAME_ITEM_QUANTITY, c[i].getQuantity());
            values.put(OrdersMaster.Orders.COL_NAME_USER_NAME, c[i].getuName());
            values.put(OrdersMaster.Orders.COL_NAME_STATUS, "Pending");
            db.insert(OrdersMaster.Orders.TBL_NAME_4, null, values);
        }
    }
}
