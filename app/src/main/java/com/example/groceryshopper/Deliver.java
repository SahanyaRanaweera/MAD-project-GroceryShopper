package com.example.groceryshopper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Deliver extends AppCompatActivity {
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);


        String ITEM_NO =getIntent().getStringExtra("keyname");
        String ITEM_NAME =getIntent().getStringExtra("keyname1");
        String NAME =getIntent().getStringExtra("keyname2");
        txt1.setText(ITEM_NO);
        txt2.setText(ITEM_NAME);
        txt3.setText(NAME);
    }
    public void goToAdminPage(View view1){
        Intent intent1 = new Intent(this, AdminActivity.class);
        startActivity(intent1);
    }

}