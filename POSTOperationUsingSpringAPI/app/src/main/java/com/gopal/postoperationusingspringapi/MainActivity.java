package com.gopal.postoperationusingspringapi;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText adminName,email,mobile,password;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminName = findViewById(R.id.adminName);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSendPostReqCheck();
            }
        });
    }

    private void btnSendPostReqCheck() {

        String adName = adminName.getText().toString();
        String mob = mobile.getText().toString();
        String em = email.getText().toString();
        String pwd = password.getText().toString();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<User> call = apiInterface.getUserInformation(adName,em,mob,pwd);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e(TAG, "onResponse: code "+response.code() );
                Log.e(TAG, "onResponse: admin name "+response.body().getAdminName() );
                Log.e(TAG, "onResponse: email "+response.body().getEmail() );
                Log.e(TAG, "onResponse: mobile "+response.body().getMobile() );
                Log.e(TAG, "onResponse: password "+response.body().getPassword() );
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });

    }
}