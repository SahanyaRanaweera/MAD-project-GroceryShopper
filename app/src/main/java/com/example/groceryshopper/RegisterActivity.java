package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groceryshopper.Database.DBHelperCustomer;
import com.example.groceryshopper.Model.Customer;

public class RegisterActivity extends AppCompatActivity {
    EditText etfname, etaddress, ethomeno, etmobile, etemail, etuname, etpwd;
    String fname,address,homeno,mobile,email,uname,pwd;
    public static final String USERNAME = "com.example.groceryshopper.username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etfname =  findViewById(R.id.etfname);
        etaddress =  findViewById(R.id.etaddress);
        ethomeno =  findViewById(R.id.ethomeno);
        etmobile =  findViewById(R.id.etmobile);
        etemail =  findViewById(R.id.etemail);
        etuname =  findViewById(R.id.etuname);
        etpwd =  findViewById(R.id.etpwd);

    }

    public void register(View view){
        DBHelperCustomer dbCustomer = new DBHelperCustomer(this);
        fname=etfname.getText().toString();
        address=etaddress.getText().toString();
        homeno=ethomeno.getText().toString();
        mobile=etmobile.getText().toString();
        email=etemail.getText().toString();
        uname=etuname.getText().toString();
        pwd=etpwd.getText().toString();
        Customer c1 = new Customer(fname,address,homeno,mobile,email,uname,pwd);
        long val = dbCustomer.addCustomer(c1);
        if(val>0){
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra(USERNAME, uname);
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(this, "Registration not successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void logout(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}