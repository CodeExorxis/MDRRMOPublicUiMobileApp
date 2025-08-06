package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        root.OTPbtnContinue.setOnClickListener(v -> {
            startActivity(new Intent(ForgotPasswordActivity.this, MainActivity.class));
            finish();
        });
    }
}