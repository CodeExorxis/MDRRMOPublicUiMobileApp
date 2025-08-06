package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivityOneTimePasswordBinding;


public class OneTimePasswordActivity extends AppCompatActivity {

    ActivityOneTimePasswordBinding root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityOneTimePasswordBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        root.OTPbtnLogin.setOnClickListener(v -> {
            startActivity(new Intent(OneTimePasswordActivity.this, MainActivity.class));
            finish();
        });

    }
}