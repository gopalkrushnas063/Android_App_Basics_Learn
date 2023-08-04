package com.example.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<EmployeeDetails> arrEmployees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrEmployees.add(new EmployeeDetails(R.drawable.a,"EMP90786","Gopal Krushna Sahoo","gks24122@gamil.com","9878676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.b,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.c,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.d,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.e,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.f,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.g,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.h,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.i,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.b,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.a,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.c,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));
        arrEmployees.add(new EmployeeDetails(R.drawable.d,"EMP90086","Radha Rani","radha_rani@gamil.com","9876676545","Software Engineer"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,arrEmployees);
        recyclerView.setAdapter(adapter);
    }
}