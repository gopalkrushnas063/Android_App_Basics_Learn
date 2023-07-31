package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtFromDt,edtToDt;
        Button btnCalculate;
        TextView txtResult;

        edtFromDt = findViewById(R.id.edtFromDt);
        edtToDt = findViewById(R.id.edtToDt);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int frDt = Integer.parseInt(edtFromDt.getText().toString());
                int toDt = Integer.parseInt(edtToDt.getText().toString());
                int result = frDt - toDt;
                txtResult.setText("Age is : "+result);
            }
        });
    }
}