package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.groceryshopper.Database.DBHelperItem;
import com.example.groceryshopper.Model.Item;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private Item[] allItems;
    TextView user;
    TextView categoryName;
    String uname;
    public static String userN;
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent = getIntent();
        uname = intent.getStringExtra(CategorylistActivity.USERNAME);
        userN = uname;
        user = findViewById(R.id.user);
        user.setText(uname);
        category = intent.getStringExtra("CategoryC");
        categoryName = findViewById(R.id.categoryName);
        categoryName.setText(category);
        initListElements(category);
    }
    private void initListElements(String category) {
        DBHelperItem db = new DBHelperItem(this);
        List<Item> allDeals = db.getItemList(category);
        allItems = new Item[allDeals.size()];
        allItems = allDeals.toArray(allItems);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter1 adapter = new RecyclerViewAdapter1(allItems,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void logout(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

}