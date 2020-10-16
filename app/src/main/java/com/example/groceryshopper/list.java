package com.example.groceryshopper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class list extends AppCompatActivity {

        TextView txt1,txt2,txt3;
        Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        btnInsert =findViewById(R.id.btnInsert);

        final String ITEM_NO =getIntent().getStringExtra("keyname");
        final String ITEM_NAME =getIntent().getStringExtra("keyname1");
        final String NAME =getIntent().getStringExtra("keyname2");
        txt1.setText(ITEM_NO);
        txt2.setText(ITEM_NAME);
        txt3.setText(NAME);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(list.this,Deliver.class);
                intent.putExtra("keyname",  ITEM_NO);
                intent.putExtra("keyname1",ITEM_NAME);
                intent.putExtra("keyname2",  NAME);
                startActivity(intent);

            }
        });

    }

}