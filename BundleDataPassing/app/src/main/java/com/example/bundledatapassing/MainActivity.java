package com.example.bundledatapassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNxt;
        btnNxt = findViewById(R.id.btnNext);
        Intent iNext = new Intent(MainActivity.this,SecondActivity.class);
        iNext.putExtra("title","Home");
        iNext.putExtra("StudentName","Gopal");
        iNext.putExtra("Roll No",10);


        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iNext);
            }
        });
    }
}