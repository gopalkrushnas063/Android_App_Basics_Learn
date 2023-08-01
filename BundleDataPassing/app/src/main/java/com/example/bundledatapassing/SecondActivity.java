package com.example.bundledatapassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromActivity = getIntent();
        String title =  fromActivity.getStringExtra("title");
        String StudentName =  fromActivity.getStringExtra("StudentName");
        int RollNo =  fromActivity.getIntExtra("Roll No",0);

        TextView txtStudentInfo;
        txtStudentInfo = findViewById(R.id.txtStudentInfo);

        txtStudentInfo.setText("Roll No : "+RollNo+", Name : "+StudentName);
//        getSupportActionBar().setTitle(title);
    }
}