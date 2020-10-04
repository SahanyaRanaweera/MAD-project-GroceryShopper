package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.groceryshopper.Database.DBHelperCustomer;
import com.example.groceryshopper.Database.DBHelperProduct;
import com.example.groceryshopper.Model.DealsList;

import java.util.List;

public class DealsActivity extends AppCompatActivity {
    private DealsList[] deals;
    TextView user;
    String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
        Intent intent = getIntent();
        uname = intent.getStringExtra(DashboardActivity.USERNAME);
        user = findViewById(R.id.user);
        user.setText(uname);
        initListElements();
    }

    private void initListElements() {
        DBHelperProduct db = new DBHelperProduct(this);
        List<DealsList> allDeals = db.getDeals();
        deals = new DealsList[allDeals.size()];
        deals = allDeals.toArray(deals);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(deals,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void logout(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}