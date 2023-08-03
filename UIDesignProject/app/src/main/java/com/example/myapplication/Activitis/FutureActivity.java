package com.example.myapplication.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.Adapters.FutureAdapters;
import com.example.myapplication.Adapters.HourlyAdapters;
import com.example.myapplication.Domains.FutureDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FutureActivity.this,MainActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Sat","storm","Storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","Cloudy",25,10));
        items.add(new FutureDomain("Mon","windy","Windy",25,10));
        items.add(new FutureDomain("Sat","cloudy_sunny","Cloudy_Sunny",25,10));
        items.add(new FutureDomain("Sat","sunny","Sunny",25,10));
        items.add(new FutureDomain("Sat","rainy","Rainy",25,10));

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTomorrow = new FutureAdapters(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}