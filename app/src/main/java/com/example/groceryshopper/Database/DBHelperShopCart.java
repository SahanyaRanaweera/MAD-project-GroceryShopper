package com.example.groceryshopper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.groceryshopper.Model.CartModel;

import java.util.ArrayList;
import java.util.List;

public class DBHelperShopCart extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GroceryShopper2.db";
    public DBHelperShopCart(Context context) {
        super(context, DATABASE_NAME, null, 12);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES2 =
                "CREATE TABLE IF NOT EXISTS "+ShopCartMaster.ShopCartItems.TBL_NAME_3+" ("+
                        ShopCartMaster.ShopCartItems._ID+" INTEGER PRIMARY KEY,"+
                        ShopCartMaster.ShopCartItems.COL_NAME_ITEM_NAME+" TEXT,"+
                        ShopCartMaster.ShopCartItems.COL_NAME_ITEM_PRICE+" TEXT,"+
                        ShopCartMaster.ShopCartItems.COL_NAME_ITEM_QUANTITY+" INTEGER,"+
                        ShopCartMaster.ShopCartItems.COL_NAME_USER_NAME+" TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES2);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }

    public long addToCart(CartModel crt1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_NAME,crt1.getItemName());
        values.put(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_PRICE,crt1.getPrice());
        values.put(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_QUANTITY,crt1.getQuantity());
        values.put(ShopCartMaster.ShopCartItems.COL_NAME_USER_NAME,crt1.getuName());
        long rowId1 = db.insert(ShopCartMaster.ShopCartItems.TBL_NAME_3,null,values);
        return rowId1;
    }

    public List<CartModel> getCartItems(String user){
        List<CartModel> cartItemList = new ArrayList<>();
        String[] projection = {
                ShopCartMaster.ShopCartItems._ID,
                ShopCartMaster.ShopCartItems.COL_NAME_ITEM_NAME,
                ShopCartMaster.ShopCartItems.COL_NAME_ITEM_PRICE,
                ShopCartMaster.ShopCartItems.COL_NAME_ITEM_QUANTITY,
                ShopCartMaster.ShopCartItems.COL_NAME_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                ShopCartMaster.ShopCartItems.TBL_NAME_3,
                projection,
                ShopCartMaster.ShopCartItems.COL_NAME_USER_NAME+"=?",
                new String[] {user},
                null,
                null,
                null
        );
        while (cursor.moveToNext()){
            CartModel c = new CartModel();
            c.setItemName(cursor.getString(cursor.getColumnIndexOrThrow(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_NAME)));
            c.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_PRICE)));
            c.setQuantity(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_QUANTITY))));
            cartItemList.add(c);
        }
        cursor.close();
        return cartItemList;
    }

    public void updateQuantity(int qty, String name, String user){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(ShopCartMaster.ShopCartItems.COL_NAME_ITEM_QUANTITY,qty);
        String selection = ShopCartMaster.ShopCartItems.COL_NAME_ITEM_NAME+" LIKE ?"+" AND "+ ShopCartMaster.ShopCartItems.COL_NAME_USER_NAME+" LIKE ?";
        String[] args = {name,user};
        db.update(
                ShopCartMaster.ShopCartItems.TBL_NAME_3,
                values,
                selection,
                args
        );
    }


}
