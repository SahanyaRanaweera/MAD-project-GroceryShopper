package com.example.groceryshopper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.groceryshopper.Model.DealsList;

import java.util.ArrayList;
import java.util.List;

public class DBHelperProduct extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GroceryShopper2.db";
    public DBHelperProduct(Context context) {
        super(context, DATABASE_NAME, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES1 =
                "CREATE TABLE "+DealsMaster.Deals.TBL_NAME_1+" ("+
                        DealsMaster.Deals._ID+" INTEGER PRIMARY KEY,"+
                        DealsMaster.Deals.COL_NAME_CATEGORY+" TEXT,"+
                        DealsMaster.Deals.COL_NAME_IMG_URL+" TEXT,"+
                        DealsMaster.Deals.COL_NAME_IMG_NAME+" TEXT,"+
                        DealsMaster.Deals.COL_NAME_PRICE+" TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES1);

        addSampleData();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DealsMaster.Deals.TBL_NAME_1);
        onCreate(db);
    }

    public void addSampleData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put(DealsMaster.Deals.COL_NAME_CATEGORY,"Bakery");
        values1.put(DealsMaster.Deals.COL_NAME_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/c687aa7517cf01e65c009f6943c2b1e9/1/6/16014.png");
        values1.put(DealsMaster.Deals.COL_NAME_IMG_NAME,"Prima Flat bread");
        values1.put(DealsMaster.Deals.COL_NAME_PRICE,"Rs. 150.00");
        db.insert(DealsMaster.Deals.TBL_NAME_1,null,values1);
        ContentValues values2 = new ContentValues();
        values2.put(DealsMaster.Deals.COL_NAME_CATEGORY,"Beverages");
        values2.put(DealsMaster.Deals.COL_NAME_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/1/9/192.jpg");
        values2.put(DealsMaster.Deals.COL_NAME_IMG_NAME,"Kist Absolute juice - Apple");
        values2.put(DealsMaster.Deals.COL_NAME_PRICE,"Rs. 560.00");
        db.insert(DealsMaster.Deals.TBL_NAME_1,null,values2);
        ContentValues values3 = new ContentValues();
        values3.put(DealsMaster.Deals.COL_NAME_CATEGORY,"Fresh fruits");
        values3.put(DealsMaster.Deals.COL_NAME_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/1/0/10111.png");
        values3.put(DealsMaster.Deals.COL_NAME_IMG_NAME,"Watermelon");
        values3.put(DealsMaster.Deals.COL_NAME_PRICE,"Rs. 260.00");
        db.insert(DealsMaster.Deals.TBL_NAME_1,null,values3);

    }
    public List<DealsList> getDeals(){
        List<DealsList> allDeals = new ArrayList<DealsList>();
        String[] projection = {
                DealsMaster.Deals._ID,
                DealsMaster.Deals.COL_NAME_CATEGORY,
                DealsMaster.Deals.COL_NAME_IMG_URL,
                DealsMaster.Deals.COL_NAME_IMG_NAME,
                DealsMaster.Deals.COL_NAME_PRICE,
        };
        String sOrder = DealsMaster.Deals.COL_NAME_CATEGORY + " ASC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                DealsMaster.Deals.TBL_NAME_1,
                projection,
                null,
                null,
                null,
                null,
                sOrder
        );

        while (cursor.moveToNext()) {
            DealsList deal1 = new DealsList();
            deal1.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(DealsMaster.Deals.COL_NAME_CATEGORY)));
            deal1.setImgUrl(cursor.getString(cursor.getColumnIndexOrThrow(DealsMaster.Deals.COL_NAME_IMG_URL)));
            deal1.setImgName(cursor.getString(cursor.getColumnIndexOrThrow(DealsMaster.Deals.COL_NAME_IMG_NAME)));
            deal1.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(DealsMaster.Deals.COL_NAME_PRICE)));
            allDeals.add(deal1);
        }

        return allDeals;
    }
}
