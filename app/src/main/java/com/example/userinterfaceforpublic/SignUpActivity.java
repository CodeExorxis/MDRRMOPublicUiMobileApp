package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivitySignUpBinding;


public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       root = ActivitySignUpBinding.inflate(getLayoutInflater());
       setContentView(root.getRoot());

        root.btnSignUp.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        });
    }
}