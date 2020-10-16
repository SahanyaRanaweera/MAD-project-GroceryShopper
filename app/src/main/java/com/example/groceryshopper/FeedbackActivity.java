package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groceryshopper.Database.FeedbackHelper;
import com.example.groceryshopper.Model.Feedback;

public class FeedbackActivity extends AppCompatActivity {
    Button buttonAdd, buttonUpdate,buttonDelete,buttonShow;
    EditText txtname, txtemail, txtmessage;
    Feedback feed;
    String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Intent intent=getIntent();
        uname=intent.getStringExtra(DashboardActivity.USERNAME);
        txtname = findViewById(R.id.ptxtname);
        txtemail = findViewById(R.id.ptxtemail);
        txtmessage = findViewById(R.id.ptxtMessage);
        feed = new Feedback();
        buttonAdd = findViewById(R.id.btnSubmit);
        buttonUpdate=findViewById(R.id.btnUpdate);
        buttonDelete=findViewById(R.id.btnDelete);
        buttonShow=findViewById(R.id.btnShow);

        final FeedbackHelper feedbackHelper=new FeedbackHelper(this);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (TextUtils.isEmpty(txtname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtemail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtmessage.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a message", Toast.LENGTH_SHORT).show();

                    else {
                        feed.setName(txtname.getText().toString().trim());
                        feed.setEmail(txtemail.getText().toString().trim());
                        feed.setMessage(txtmessage.getText().toString().trim());

                        //Insert in to the databse...
                        feedbackHelper.addFeed(feed);
                        //Feedback to the user via a Toast...
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();

                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (TextUtils.isEmpty(txtname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtemail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtmessage.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a message", Toast.LENGTH_SHORT).show();

                    else {
                        feed.setName(txtname.getText().toString().trim());
                        feed.setEmail(txtemail.getText().toString().trim());
                        feed.setMessage(txtmessage.getText().toString().trim());

                        //Update the databse...
                        feedbackHelper.updateFeed(feed.getName(),feed.getMessage());
                        //Feedback to the user via a Toast...
                        Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();

                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (TextUtils.isEmpty(txtname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();


                    else {
                        feed.setName(txtname.getText().toString().trim());
                        feed.setEmail(txtemail.getText().toString().trim());
                        feed.setMessage(txtmessage.getText().toString().trim());

                        //Delete the feed from databse...
                        feedbackHelper.deleteFeed(feed.getName());
                        //Feedback to the user via a Toast...
                        Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_LONG).show();

                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void showFeeds(View view){
        Intent intent1 = new Intent(this,FeedbackListActivity.class);
        startActivity(intent1);
    }
    public void backToDashboard(View view){
        Intent intent1 = new Intent(this,DashboardActivity.class);
        intent1.putExtra("USERNAME", uname);
        startActivity(intent1);
    }
}