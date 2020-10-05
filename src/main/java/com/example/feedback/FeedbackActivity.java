package com.example.shopsinfinifyy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {
    DatabaseReference dbRef;
    Feedback feed;
    TextView txtname, txtemail, txtcomment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");

        txtname = findViewById(R.id.nametxt);
        txtemail = findViewById(R.id.emailtxt);
        txtcomment = findViewById(R.id.commenttxt);
        Intent i = getIntent();

        txtname.setText(i.getStringExtra("name"));
        txtemail.setText(i.getStringExtra("mail"));
        txtcomment.setText(i.getStringExtra("comment"));

    }
    public void back(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
