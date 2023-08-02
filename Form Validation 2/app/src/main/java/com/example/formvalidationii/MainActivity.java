package com.example.formvalidationii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputName, inputEmail, inputPin, inputMobile;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPin = findViewById(R.id.inputPin);
        inputMobile = findViewById(R.id.inputMobile);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    // Success Alert
                    showAlert("Successfully Validate Form!");
                }
                else{
                    // Failed alert
                    showAlert("Something went wrong!");
                }
            }
        });
    }


    private boolean validateForm() {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String pin = inputPin.getText().toString().trim();
        String mobile = inputMobile.getText().toString().trim();

        // name should not empty
        if (name.isEmpty()) {
            inputName.setError("Name should not empty");
            return false;
        }

        // email validation
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            inputEmail.setError("Invalid Email");
            return false;
        }

        // PIN Validation
        if (pin.length() != 6) {
            inputPin.setError("Pincode should be 6 digits");
            return false;
        }

        if (mobile.length() != 10) {
            inputMobile.setError("Mobile number should be 10 digits");
            return false;
        }

        // if all passed
        return true;
    }

    private void showAlert(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}