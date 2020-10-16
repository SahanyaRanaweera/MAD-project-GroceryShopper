package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groceryshopper.Database.DBHelperCustomer;

public class LoginActivity extends AppCompatActivity {
    EditText etuname, etpwd;
    String uname, pwd;
    public static final String USERNAME = "com.example.groceryshopper.username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etuname =  findViewById(R.id.etuname);
        etpwd =  findViewById(R.id.etpwd);
    }

    public void login(View view){
        DBHelperCustomer dbCustomer = new DBHelperCustomer(this);
        uname=etuname.getText().toString();
        pwd=etpwd.getText().toString();
        boolean val = dbCustomer.getLogin(uname,pwd);
        if(val == true){
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra(USERNAME, uname);
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else if(uname.equals("admin") && pwd.equals("admin")){
            Intent intent = new Intent(this, AdminActivity.class);
            Toast.makeText(this, "Login as admin", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToRegistration(View view1){
        Intent intent1 = new Intent(this, RegisterActivity.class);
        startActivity(intent1);
    }
}