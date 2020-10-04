package com.example.groceryshopper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.groceryshopper.Model.Item;

import java.util.ArrayList;
import java.util.List;


public class DBHelperItem extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GroceryShopper2.db";
    public DBHelperItem(Context context) {
        super(context, DATABASE_NAME, null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES1 =
                "CREATE TABLE "+ItemsMaster.Items.TBL_NAME_2+" ("+
                        ItemsMaster.Items._ID+" INTEGER PRIMARY KEY,"+
                        ItemsMaster.Items.COL_NAME_I_CATEGORY+" TEXT,"+
                        ItemsMaster.Items.COL_NAME_I_IMG_URL+" TEXT,"+
                        ItemsMaster.Items.COL_NAME_I_IMG_NAME+" TEXT,"+
                        ItemsMaster.Items.COL_NAME_I_PRICE+" TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES1);
        addSampleData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ItemsMaster.Items.TBL_NAME_2);
        onCreate(db);
    }

    public void addSampleData(SQLiteDatabase db){

        ContentValues values1 = new ContentValues();
        values1.put(ItemsMaster.Items.COL_NAME_I_CATEGORY,"Bakery");
        values1.put(ItemsMaster.Items.COL_NAME_I_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/c687aa7517cf01e65c009f6943c2b1e9/1/6/16014.png");
        values1.put(ItemsMaster.Items.COL_NAME_I_IMG_NAME,"Prima Flat bread");
        values1.put(ItemsMaster.Items.COL_NAME_I_PRICE,"Rs. 150.00");
        db.insert(ItemsMaster.Items.TBL_NAME_2,null,values1);
        ContentValues values2 = new ContentValues();
        values2.put(ItemsMaster.Items.COL_NAME_I_CATEGORY,"Beverages");
        values2.put(ItemsMaster.Items.COL_NAME_I_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/1/9/192.jpg");
        values2.put(ItemsMaster.Items.COL_NAME_I_IMG_NAME,"Kist Absolute juice - Apple");
        values2.put(ItemsMaster.Items.COL_NAME_I_PRICE,"Rs. 560.00");
        db.insert(ItemsMaster.Items.TBL_NAME_2,null,values2);
        ContentValues values3 = new ContentValues();
        values3.put(ItemsMaster.Items.COL_NAME_I_CATEGORY,"Fresh fruits");
        values3.put(ItemsMaster.Items.COL_NAME_I_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/1/0/10111.png");
        values3.put(ItemsMaster.Items.COL_NAME_I_IMG_NAME,"Watermelon");
        values3.put(ItemsMaster.Items.COL_NAME_I_PRICE,"Rs. 260.00");
        db.insert(ItemsMaster.Items.TBL_NAME_2,null,values3);
        ContentValues values4 = new ContentValues();
        values4.put(ItemsMaster.Items.COL_NAME_I_CATEGORY,"Dairy Products");
        values4.put(ItemsMaster.Items.COL_NAME_I_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/3/3/339.jpg");
        values4.put(ItemsMaster.Items.COL_NAME_I_IMG_NAME,"Anchor Fresh milk");
        values4.put(ItemsMaster.Items.COL_NAME_I_PRICE,"Rs. 210.00");
        db.insert(ItemsMaster.Items.TBL_NAME_2,null,values4);
        ContentValues values5 = new ContentValues();
        values5.put(ItemsMaster.Items.COL_NAME_I_CATEGORY,"Beverages");
        values5.put(ItemsMaster.Items.COL_NAME_I_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/5/0/5078.png");
        values5.put(ItemsMaster.Items.COL_NAME_I_IMG_NAME,"7up 500ml");
        values5.put(ItemsMaster.Items.COL_NAME_I_PRICE,"Rs. 100.00");
        db.insert(ItemsMaster.Items.TBL_NAME_2,null,values5);
        ContentValues values6 = new ContentValues();
        values6.put(ItemsMaster.Items.COL_NAME_I_CATEGORY,"Bakery");
        values6.put(ItemsMaster.Items.COL_NAME_I_IMG_URL,"https://www.hi2world.com/pub/media/catalog/product/cache/9a9f4f951b9dbb2dac764f9fa67fd66e/1/6/16011.png");
        values6.put(ItemsMaster.Items.COL_NAME_I_IMG_NAME,"Prima White bread");
        values6.put(ItemsMaster.Items.COL_NAME_I_PRICE,"Rs. 180.00");
        db.insert(ItemsMaster.Items.TBL_NAME_2,null,values6);

    }

    public List<String> getCategoryList(){
        List<String> categories = new ArrayList<>();
        String sOrder = ItemsMaster.Items.COL_NAME_I_CATEGORY+" ASC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                ItemsMaster.Items.TBL_NAME_2,
                new String[] {ItemsMaster.Items.COL_NAME_I_CATEGORY},
                null,
                null,
                ItemsMaster.Items.COL_NAME_I_CATEGORY,
                null,
                sOrder
        );
        while (cursor.moveToNext()) {
            String s = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COL_NAME_I_CATEGORY));
            categories.add(s);
        }
        return categories;
    }

    public List<Item> getItemList(String category){
        List<Item> items = new ArrayList<>();
        String sOrder = ItemsMaster.Items.COL_NAME_I_CATEGORY+" ASC";
        String[] projection = {
            ItemsMaster.Items._ID,
            ItemsMaster.Items.COL_NAME_I_CATEGORY,
            ItemsMaster.Items.COL_NAME_I_IMG_URL,
            ItemsMaster.Items.COL_NAME_I_IMG_NAME,
            ItemsMaster.Items.COL_NAME_I_PRICE,
        };
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                ItemsMaster.Items.TBL_NAME_2,
                projection,
                ItemsMaster.Items.COL_NAME_I_CATEGORY+"=?",
                new String[] {category},
                null,
                null,
                null
        );
        while (cursor.moveToNext()) {
            Item i1 = new Item();
            i1.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COL_NAME_I_CATEGORY)));
            i1.setImgUrl(cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COL_NAME_I_IMG_URL)));
            i1.setImgName(cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COL_NAME_I_IMG_NAME)));
            i1.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COL_NAME_I_PRICE)));
            items.add(i1);
        }
        return items;
    }
}
