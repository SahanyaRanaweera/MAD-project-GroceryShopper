package com.example.groceryshopper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.groceryshopper.Database.Constants;
import com.example.groceryshopper.Database.DatabaseHelper;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView mRecyclerView;

    private DatabaseHelper databaseHelper;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        actionBar = getSupportActionBar();
        actionBar.setTitle("All Records");

        fab = findViewById(R.id.addFabButton);
        mRecyclerView = findViewById(R.id.recyclerview);

        databaseHelper = new DatabaseHelper(this);

        showRecord();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, AddRecordActivity.class);
                intent.putExtra("editMode", false);
                startActivity(intent);
            }
        });
    }

    private void showRecord() {

        Adapter adapter = new Adapter(MainActivity2.this,
                databaseHelper.getAllData(Constants.C_Add_TIMESTAMP + " DESC"));

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(MainActivity2.this, AdminActivity.class);
            finish();
            startActivity(intent);
        }

        return true;
    }
}


