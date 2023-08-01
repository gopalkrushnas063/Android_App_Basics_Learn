package com.example.customanimationlottie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView laView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the LottieAnimationView by its ID from the layout XML
        laView = findViewById(R.id.lottieID);

        if (laView != null) {
            // Set the animation using a resource ID (R.raw.lottie)
            laView.setAnimation(R.raw.lottie);
            // Set looping to true
            laView.loop(true);
        } else {
            // Handle the case where the laView is null (optional)
            // For example, show an error message or perform a fallback action.
        }
    }
}
