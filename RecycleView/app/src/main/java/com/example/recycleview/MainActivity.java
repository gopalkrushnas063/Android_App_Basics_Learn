package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrContacts.add(new ContactModel(R.drawable.a, "Gopal", "9937220643"));
        arrContacts.add(new ContactModel(R.drawable.b, "Krishna", "7008268713"));
        arrContacts.add(new ContactModel(R.drawable.c, "Mohan", "9878675643"));
        arrContacts.add(new ContactModel(R.drawable.a, "Hari", "9878675643"));
        arrContacts.add(new ContactModel(R.drawable.e, "Madan", "6754567898"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}