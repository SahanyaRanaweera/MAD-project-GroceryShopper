package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    TextView user;
    public static String uname;
    public static final String USERNAME = "com.example.groceryshopper.username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        uname = intent.getStringExtra(RegisterActivity.USERNAME);
        if (uname == null){
            uname = intent.getStringExtra(LoginActivity.USERNAME);
        }
        user = findViewById(R.id.user);
        user.setText(uname);
    }

    public void goToDailyDeals(View view1){
        Intent intent1 = new Intent(this, DealsActivity.class);
        intent1.putExtra(USERNAME, uname);
        startActivity(intent1);
    }
    public void goToCategoriesList(View view1){
        Intent intent1 = new Intent(this, CategorylistActivity.class);
        intent1.putExtra(USERNAME, uname);
        startActivity(intent1);
    }
    public void goToShoppingCart(View view1){
        Intent intent1 = new Intent(this, ShoppingcartActivity.class);
        intent1.putExtra(USERNAME, uname);
        startActivity(intent1);
    }

    public void logout(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}