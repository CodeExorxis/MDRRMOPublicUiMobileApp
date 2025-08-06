package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivityChangePasswordBinding;

public class ChangePasswordActivity extends AppCompatActivity {

    ActivityChangePasswordBinding root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        root.OTPbtnSubmit.setOnClickListener(v -> {
            startActivity(new Intent(ChangePasswordActivity.this, MainActivity.class));
        });
    }
}