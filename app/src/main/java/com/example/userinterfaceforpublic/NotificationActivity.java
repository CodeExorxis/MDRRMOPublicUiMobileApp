package com.example.userinterfaceforpublic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.userinterfaceforpublic.databinding.ActivityNotificationBinding;
import com.example.userinterfaceforpublic.databinding.NavigationDrawerBinding;
import com.example.userinterfaceforpublic.databinding.ToolBarBinding;

public class NotificationActivity extends AppCompatActivity {

    ActivityNotificationBinding root;
    ToolBarBinding toolbarBinding;
    NavigationDrawerBinding navDrawerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        // Included layouts
        toolbarBinding = root.tool;
        navDrawerBinding = root.navDrawer;

        // Menu click (toolbar)
        toolbarBinding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(root.drawerLayout);
            }
        });

        // Home
        navDrawerBinding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, MainActivity.class);
            }
        });

        // Emergency Guides
        navDrawerBinding.emGuides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, EmergencyGuideActivity.class);
            }
        });

        // Notification (refresh)
        navDrawerBinding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        // Settings
        navDrawerBinding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(NotificationActivity.this, SettingsActivity.class);
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
        closeDrawer(root.drawerLayout);
    }
}