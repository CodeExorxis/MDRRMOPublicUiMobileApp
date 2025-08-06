package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivityLogInBinding;

public class LogInActivity extends AppCompatActivity {

    // ViewBinding object
    ActivityLogInBinding root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize binding
        root = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        // Set button click listener
        root.btnLogin.setOnClickListener(v -> {
            // Navigate to MainActivity
            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // optional
        });

        root.txtForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        // Sign Up click
        root.txtSignUp.setOnClickListener(v -> {
            startActivity(new Intent(LogInActivity.this, SignUpActivity.class));
        });
    }
}