package com.example.userinterfaceforpublic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.userinterfaceforpublic.databinding.ActivityEmergencyGuideBinding;
import com.example.userinterfaceforpublic.databinding.NavigationDrawerBinding;
import com.example.userinterfaceforpublic.databinding.ToolBarBinding;

public class EmergencyGuideActivity extends AppCompatActivity {

    private ActivityEmergencyGuideBinding binding;
    private ToolBarBinding toolbarBinding;
    private NavigationDrawerBinding navDrawerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate ViewBinding
        binding = ActivityEmergencyGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Access included layouts
        toolbarBinding = binding.tool;
        navDrawerBinding = binding.navDrawer;

        // Menu click (toolbar)
        toolbarBinding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(binding.drawerLayout);
            }
        });

        // Home click
        navDrawerBinding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(EmergencyGuideActivity.this, MainActivity.class);
            }
        });

        // Emergency Guides (refresh current)
        navDrawerBinding.emGuides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        // Notifications
        navDrawerBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(EmergencyGuideActivity.this, NotificationActivity.class);
            }
        });

        // Settings
        navDrawerBinding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(EmergencyGuideActivity.this, SettingsActivity.class);
            }
        });
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class<?> secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(binding.drawerLayout);
    }
}