package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToRegistration(View view1){
        Intent intent1 = new Intent(this, RegisterActivity.class);
        startActivity(intent1);
    }
    public void goToLogin(View view2){
        Intent intent2 = new Intent(this, LoginActivity.class);
        startActivity(intent2);
    }
}