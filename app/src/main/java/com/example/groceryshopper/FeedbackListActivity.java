package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.groceryshopper.Database.FeedbackHelper;
import com.example.groceryshopper.Model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackListActivity extends AppCompatActivity {
    LinearLayout linearLayout1;
    LinearLayout[] linearLayouts;
    TextView[] names;
    TextView[] emails;
    TextView[] messages;
    Feedback[] feedArray;
    List<Feedback> feedList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_list);
        display();
    }

    private void display() {
        FeedbackHelper feedbackHelper = new FeedbackHelper(this);
        feedList = feedbackHelper.show();
        feedArray=new Feedback[feedList.size()];
        feedArray=feedList.toArray(feedArray);
        names=new TextView[feedList.size()];
        emails=new TextView[feedList.size()];
        messages=new TextView[feedList.size()];
        linearLayouts= new LinearLayout[feedList.size()];
        linearLayout1 = (LinearLayout) findViewById(R.id.linear1);

        for(int i=0; i<feedArray.length;i++){
            names[i]=new TextView(this);
            names[i].setTextSize(18);
            names[i].setPadding(20,10,20,10);
            names[i].setTextColor(Color.parseColor("#000000"));
            names[i].setText(feedArray[i].getName());
            emails[i]=new TextView(this);
            emails[i].setTextSize(18);
            emails[i].setPadding(20,10,20,10);
            emails[i].setTextColor(Color.parseColor("#000000"));
            emails[i].setText(feedArray[i].getEmail());
            messages[i]=new TextView(this);
            messages[i].setTextSize(18);
            messages[i].setPadding(20,10,20,10);
            messages[i].setTextColor(Color.parseColor("#000000"));
            messages[i].setText(feedArray[i].getMessage());
            linearLayouts[i]= new LinearLayout(this);
            linearLayouts[i].addView(names[i]);
            linearLayouts[i].addView(emails[i]);
            linearLayouts[i].addView(messages[i]);
            linearLayout1.addView(linearLayouts[i]);

        }
    }

    public void goBack(View view){
        Intent intent1 = new Intent(this,FeedbackActivity.class);
        startActivity(intent1);
    }
}