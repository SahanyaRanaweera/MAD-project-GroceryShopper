package com.example.groceryshopper.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.groceryshopper.Model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GroceryShopper2.db";
    public FeedbackHelper(Context context) {
        super(context, DATABASE_NAME, null, 12);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES=
                "CREATE TABLE IF NOT EXISTS "+ FeedbackMaster.Feedback.TBL_NAME+" ("+
                        FeedbackMaster.Feedback._ID+" INTEGER PRIMARY KEY,"+
                        FeedbackMaster.Feedback.COL_NAME_NAME+" TEXT,"+
                        FeedbackMaster.Feedback.COL_NAME_EMAIL+" TEXT,"+
                        FeedbackMaster.Feedback.COL_NAME_MESSAGE+" TEXT)";
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onOpen(sqLiteDatabase);
    }

    public void addFeed(Feedback f){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedbackMaster.Feedback.COL_NAME_NAME,f.getName());
        contentValues.put(FeedbackMaster.Feedback.COL_NAME_EMAIL,f.getEmail());
        contentValues.put(FeedbackMaster.Feedback.COL_NAME_MESSAGE,f.getMessage());
        db.insert(FeedbackMaster.Feedback.TBL_NAME,null,contentValues);
    }

    public void updateFeed(String name, String message){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(FeedbackMaster.Feedback.COL_NAME_MESSAGE,message);
        String selection= FeedbackMaster.Feedback.COL_NAME_NAME+" LIKE ?";
        String[] args={name};
        sqLiteDatabase.update(
                FeedbackMaster.Feedback.TBL_NAME,
                contentValues,
                selection,
                args
        );


    }
    public void deleteFeed(String name){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String selection= FeedbackMaster.Feedback.COL_NAME_NAME+" LIKE ?";
        String[] args={name};
        sqLiteDatabase.delete(FeedbackMaster.Feedback.TBL_NAME,selection,args);
    }
    List<Feedback> feeds = new ArrayList<>();
    public List<Feedback> show(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String[] data ={
                FeedbackMaster.Feedback.COL_NAME_NAME,
                FeedbackMaster.Feedback.COL_NAME_EMAIL,
                FeedbackMaster.Feedback.COL_NAME_MESSAGE
        };
        Cursor cursor=sqLiteDatabase.query(
                FeedbackMaster.Feedback.TBL_NAME,
                data,
                null,
                null,
                null,
                null,
                null
        );
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(FeedbackMaster.Feedback.COL_NAME_NAME));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(FeedbackMaster.Feedback.COL_NAME_EMAIL));
            String message = cursor.getString(cursor.getColumnIndexOrThrow(FeedbackMaster.Feedback.COL_NAME_MESSAGE));
            Feedback f = new Feedback(name,email,message);
            feeds.add(f);
        }
        cursor.close();
        return feeds;


    }
}
