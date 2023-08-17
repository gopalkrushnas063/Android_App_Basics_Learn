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

    private EditText name,job;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        job = findViewById(R.id.job);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSendPostReqCheck();
            }
        });
    }

    private void btnSendPostReqCheck() {

        String edName = name.getText().toString();
        String edJob = job.getText().toString();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<User> call = apiInterface.getUserInformation(edName,edJob);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e(TAG, "onResponse: code "+response.code() );
                Log.e(TAG, "onResponse: name "+response.body().getName() );
                Log.e(TAG, "onResponse: job "+response.body().getJob() );
                Log.e(TAG, "onResponse: id "+response.body().getId() );
                Log.e(TAG, "onResponse: createdAt "+response.body().getCreatedAt() );
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });

    }
}