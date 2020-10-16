package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void staffRecords(View view1){
        Intent intent1 = new Intent(this, MainActivity2.class);
        startActivity(intent1);
    }
    public void checkOrders(View view1){
        Intent intent1 = new Intent(this, Animation.class);
        startActivity(intent1);
    }
    public void logout(View view1){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}