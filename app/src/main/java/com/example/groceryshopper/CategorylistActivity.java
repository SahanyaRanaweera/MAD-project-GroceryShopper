package com.example.groceryshopper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceryshopper.Database.DBHelperItem;
import com.example.groceryshopper.Model.Item;

import java.util.List;

public class CategorylistActivity extends AppCompatActivity {
    Button[] btnWord;
    LinearLayout linear;
    String[] iList;
    TextView user;
    String uname;
    public static final String USERNAME = "com.example.groceryshopper.username";
    String categoryClk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorylist);
        Intent intent = getIntent();
        uname = intent.getStringExtra(DashboardActivity.USERNAME);
        user = findViewById(R.id.user);
        user.setText(uname);
        addContent();
    }

    private void addContent() {
        DBHelperItem dbHelperItem = new DBHelperItem(this);
        List<String> itemList= dbHelperItem.getCategoryList();
        btnWord = new Button[itemList.size()];
        iList = new String[itemList.size()];
        iList = itemList.toArray(iList);
        linear = (LinearLayout) findViewById(R.id.linearLayout2);

        for (int i = 0; i < btnWord.length; i++) {
            btnWord[i] = new Button(this);
            btnWord[i].setHeight(50);
            btnWord[i].setWidth(50);
            btnWord[i].setTag(i);
            btnWord[i].setText(iList[i]);
            btnWord[i].setBackgroundResource(android.R.drawable.editbox_dropdown_light_frame);
            btnWord[i].setPadding(10,10,10,10);
            btnWord[i].setOnClickListener(btnClicked);
            linear.addView(btnWord[i]);
        }
    }
    View.OnClickListener btnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Object tag = v.getTag();
            categoryClk = btnWord[(int) tag].getText().toString();
            goToCategory(v);
        }
    };
    public void goToCategory(View view){
        Intent intent1 = new Intent(this,CategoryActivity.class);
        intent1.putExtra(USERNAME, uname);
        intent1.putExtra("CategoryC",categoryClk);
        startActivity(intent1);
    }
}