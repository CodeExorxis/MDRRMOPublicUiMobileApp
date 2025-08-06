package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivitySplashScreenBinding;


public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreenActivity.this, LogInActivity.class));
            finish();
        }, 2000);
    }
}