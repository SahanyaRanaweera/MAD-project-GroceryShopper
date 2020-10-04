package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmptyCartActivity extends AppCompatActivity {
    TextView user;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_cart);
        Intent intent = getIntent();
        uname = intent.getStringExtra("user");
        user = findViewById(R.id.user);
        TextView txtEmptyCart = findViewById(R.id.emptyCart);
        txtEmptyCart.setText("No items to display...");
        txtEmptyCart.setPadding(10,10,10,10);

    }
}