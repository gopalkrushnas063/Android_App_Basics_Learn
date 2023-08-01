package com.example.listspinnerautocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView actxtView;
    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrLanguages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        actxtView = findViewById(R.id.actxtView);

        // add all data in arrNames using collections
        Collections.addAll(arrNames, "Gopal", "Krishna", "Mohan", "Hari", "Madan", "Sudama", "Ranjit", "Surya", "Gopal", "Krishna", "Mohan", "Hari", "Madan", "Sudama", "Ranjit", "Surya", "Gopal", "Krishna", "Mohan", "Hari", "Madan", "Sudama", "Ranjit", "Surya", "Gopal", "Krishna", "Mohan", "Hari", "Madan", "Sudama", "Ranjit", "Surya");

        // add all data in arrIds
        arrIds.add("Aadhaar Card");
        arrIds.add("PAN Card");
        arrIds.add("NERGS Card");
        arrIds.add("College ID Card");

        // add all data in arrLanguages
        Collections.addAll(arrLanguages, "Hindi", "English", "Odia", "Telegue", "Marathi");


        ArrayAdapter<String> adapterListView = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adapterListView);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrIds);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        ArrayAdapter<String> adapterAutoCompleteTextView = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanguages);
        actxtView.setAdapter(adapterAutoCompleteTextView);
        actxtView.setThreshold(1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Welcome Gopal's World", Toast.LENGTH_SHORT).show();
                }
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedIds = adapterView.getItemAtPosition(position).toString();

                Toast.makeText(MainActivity.this,"Selected: "+selectedIds,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}