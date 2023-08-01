package com.example.formvlidation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editEmail, editMobile, editAddress, editPincode;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI components
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editMobile = findViewById(R.id.editMobile);
        editAddress = findViewById(R.id.editAddress);
        editPincode = findViewById(R.id.editPincode);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    // Form validation successful
                    showToast("Form validation successful! Data submitted.");
                } else {
                    // Form validation failed
                    showToast("Invalid input! Please check the form.");
                }
            }
        });
    }

    private boolean validateForm() {
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String mobile = editMobile.getText().toString().trim();
        String address = editAddress.getText().toString().trim();
        String pincode = editPincode.getText().toString().trim();

        // Validate name (name should not be empty)
        if (name.isEmpty()) {
            editName.setError("Name cannot be empty");
            return false;
        }

        // Validate email (using a simple email pattern)
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Invalid email");
            return false;
        }

        // Validate mobile number (10 digits)
        if (mobile.length() != 10) {
            editMobile.setError("Mobile number should be 10 digits");
            return false;
        }

        // Validate address (address should not be empty)
        if (address.isEmpty()) {
            editAddress.setError("Address cannot be empty");
            return false;
        }

        // Validate pincode (6 digits)
        if (pincode.length() != 6) {
            editPincode.setError("Pincode should be 6 digits");
            return false;
        }

        // All validation passed
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
