package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        user.setText(uname);
        TextView txtEmptyCart = findViewById(R.id.emptyCart);
        txtEmptyCart.setText("No items to display...");
        txtEmptyCart.setPadding(10,10,10,10);

    }
    public void logout(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
    public void gotoDashboard(View v){
        Intent intent1 = new Intent(this, DashboardActivity.class);
        intent1.putExtra("USERNAME", uname);
        startActivity(intent1);
    }
}