package com.example.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button btnTranslate, btnAlpha, btnRotate, btnScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnTranslate = findViewById(R.id.btnTranslate);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnRotate = findViewById(R.id.btnRotate);
        btnScale = findViewById(R.id.btnScale);

        btnTranslate.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnTranslate) {
            animate(R.anim.translate_anim);
        } else if (viewId == R.id.btnAlpha) {
            animate(R.anim.alpha_anim);
        } else if (viewId == R.id.btnRotate) {
            animate(R.anim.rotate_anim);
        } else if (viewId == R.id.btnScale) {
            animate(R.anim.scale_anim);
        }
    }


    private void animate(int animResId) {
        Animation animation = AnimationUtils.loadAnimation(this, animResId);
        textView.startAnimation(animation);
    }
}
