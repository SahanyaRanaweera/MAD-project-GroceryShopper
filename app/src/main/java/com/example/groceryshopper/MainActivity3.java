package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groceryshopper.Database.DatabaseHelepr;

public class MainActivity3 extends AppCompatActivity {

    Button btnInsert;
    EditText etItemNo,etItemName,etName;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnInsert = (Button)findViewById(R.id.btnInsert);

        etItemNo = (EditText)findViewById(R.id.etItemNo);
        etItemName = (EditText)findViewById(R.id.etItemName);
        etName = (EditText)findViewById(R.id.etName);
        openHelper = new DatabaseHelepr(this);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ITEM_NO = etItemNo.getText().toString();
                String ITEM_NAME = etItemName.getText().toString();
                String NAME = etName.getText().toString();
                db = openHelper.getWritableDatabase();
                insertData(ITEM_NO,ITEM_NAME,NAME);
                Toast.makeText(getApplicationContext(),"Inserted Succesfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this,list.class);
                intent.putExtra("keyname",ITEM_NO);
                intent.putExtra("keyname1",ITEM_NAME);
                intent.putExtra("keyname2",NAME);
                startActivity(intent);
            }
        });
    }
    public  void insertData(String ITEM_NO,String ITEM_NAME,String NAME){

        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelepr.COLS_2,ITEM_NO);
        contentValues.put(DatabaseHelepr.COLS_3,ITEM_NAME);
        contentValues.put(DatabaseHelepr.COLS_4,NAME);
        long id = db.insert(DatabaseHelepr.TABLE_NAME,null,contentValues);

    }
}