package com.example.userinterfaceforpublic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.userinterfaceforpublic.databinding.ActivityNoInternetBinding;

public class NoInternetActivity extends AppCompatActivity {


    ActivityNoInternetBinding root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityNoInternetBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());


        // This method of SMS will redirect to the SMS outside the system
        root.btnSmsSmart.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09395131408"));  // This is the number that redirect outside the application
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");  // Optional
            startActivity(intent);
        });

        root.btnSmsGlobe.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09773289562"));  // This is the number that redirect outside the application
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");  // Optional
            startActivity(intent);
        });
    }
}