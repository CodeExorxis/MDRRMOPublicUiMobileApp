package com.example.userinterfaceforpublic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.userinterfaceforpublic.databinding.ActivityMainBinding;
import com.example.userinterfaceforpublic.databinding.NavigationDrawerBinding;
import com.example.userinterfaceforpublic.databinding.ToolBarBinding;
import com.example.userinterfaceforpublic.databinding.ActivityLogInBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding root;
    LogInActivity root1;
    ToolBarBinding toolbarBinding;
    NavigationDrawerBinding navDrawerBinding;

    String selectedMedicalCondition = "";
    String selectedVehicularCondition = "";
    String selectedDisasterCondition = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

        // Access included layouts
        toolbarBinding = root.tool;
        navDrawerBinding = root.navDrawer;

        // Open navigation drawer
        toolbarBinding.menu.setOnClickListener(view -> openDrawer(root.drawerLayout));

        // Navigation drawer actions
        navDrawerBinding.home.setOnClickListener(view -> recreate());
        navDrawerBinding.emGuides.setOnClickListener(view -> redirectActivity(MainActivity.this, EmergencyGuideActivity.class));
        navDrawerBinding.notification.setOnClickListener(view -> redirectActivity(MainActivity.this, NotificationActivity.class));
        navDrawerBinding.settings.setOnClickListener(view -> redirectActivity(MainActivity.this, SettingsActivity.class));

        // Show emergency category
        root.btnEmReport.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.VISIBLE);
            root.btnEmReport.setVisibility(View.GONE);
            root.btnEmHotLine.setVisibility(View.GONE);
        });

        // Show emergency hotline
        root.btnEmHotLine.setOnClickListener(v -> {
            root.EmergencyNumOptionsLayout.setVisibility(View.VISIBLE);
            root.btnEmReport.setVisibility(View.GONE);
            root.btnEmHotLine.setVisibility(View.GONE);
        });

        // Emergency category selections
        root.btnMedical.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.GONE);
            root.medicalOptionsLayout.setVisibility(View.VISIBLE);
        });

        root.btnVehicular.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.GONE);
            root.vehicularOptionsLayout.setVisibility(View.VISIBLE);
        });

        root.btnDisaster.setOnClickListener(v -> {
            root.emergencyCategories.setVisibility(View.GONE);
            root.disasterOptionsLayout.setVisibility(View.VISIBLE);
        });

        // --- Medical options ---
        root.btnHeartAttack.setOnClickListener(v -> {
            selectedMedicalCondition = "Heart Attack";
            root.edtOtherMedical.setText("");
            resetMedicalButtons();
            root.btnHeartAttack.setBackgroundResource(R.drawable.button_selected_flat);
        });

        root.btnHighFever.setOnClickListener(v -> {
            selectedMedicalCondition = "High Fever";
            root.edtOtherMedical.setText("");
            resetMedicalButtons();
            root.btnHighFever.setBackgroundResource(R.drawable.button_selected_flat);
        });

        root.edtOtherMedical.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                selectedMedicalCondition = "";
                resetMedicalButtons();
            }
        });

        root.btnSubmitMedical.setOnClickListener(v -> {
            String otherInput = root.edtOtherMedical.getText().toString().trim();
            if (!otherInput.isEmpty()) {
                selectedMedicalCondition = otherInput;
            }

            if (selectedMedicalCondition.isEmpty()) {
                Toast.makeText(this, "Please select or enter a medical condition.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Submitted: " + selectedMedicalCondition, Toast.LENGTH_SHORT).show();
            root.medicalOptionsLayout.setVisibility(View.GONE);
            root.btnEmReport.setVisibility(View.VISIBLE);
            root.btnEmHotLine.setVisibility(View.VISIBLE);
            root.edtOtherMedical.setText("");
            resetMedicalButtons();
            selectedMedicalCondition = "";
        });

        // --- Vehicular options ---
        root.btnOneCasualty.setOnClickListener(v -> {
            selectedVehicularCondition = "One Casualty";
            resetVehicularButtons();
            root.btnOneCasualty.setBackgroundResource(R.drawable.button_selected_flat);
        });

        root.btnMultipleCasualty.setOnClickListener(v -> {
            selectedVehicularCondition = "Multiple Casualty";
            resetVehicularButtons();
            root.btnMultipleCasualty.setBackgroundResource(R.drawable.button_selected_flat);
        });

        root.btnSubmitVehicular.setOnClickListener(v -> {
            if (selectedVehicularCondition.isEmpty()) {
                Toast.makeText(this, "Please select a vehicular condition.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Submitted: " + selectedVehicularCondition, Toast.LENGTH_SHORT).show();
            root.vehicularOptionsLayout.setVisibility(View.GONE);
            root.btnEmReport.setVisibility(View.VISIBLE);
            root.btnEmHotLine.setVisibility(View.VISIBLE);
            resetVehicularButtons();
            selectedVehicularCondition = "";
        });

        // --- Disaster options ---
        root.btnEarthquake.setOnClickListener(v -> {
            selectedDisasterCondition = "Earthquake";
            root.edtOtherDisaster.setText("");
            resetDisasterButtons();
            root.btnEarthquake.setBackgroundResource(R.drawable.button_selected_flat);
        });

        root.btnTyphoon.setOnClickListener(v -> {
            selectedDisasterCondition = "Typhoon";
            root.edtOtherDisaster.setText("");
            resetDisasterButtons();
            root.btnTyphoon.setBackgroundResource(R.drawable.button_selected_flat);
        });

        root.edtOtherDisaster.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                selectedDisasterCondition = "";
                resetDisasterButtons();
            }
        });

        root.btnSubmitDisaster.setOnClickListener(v -> {
            String otherInput = root.edtOtherDisaster.getText().toString().trim();
            if (!otherInput.isEmpty()) {
                selectedDisasterCondition = otherInput;
            }

            if (selectedDisasterCondition.isEmpty()) {
                Toast.makeText(this, "Please select or enter a disaster type.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Submitted: " + selectedDisasterCondition, Toast.LENGTH_SHORT).show();
            root.disasterOptionsLayout.setVisibility(View.GONE);
            root.btnEmReport.setVisibility(View.VISIBLE);
            root.btnEmHotLine.setVisibility(View.VISIBLE);
            root.edtOtherDisaster.setText("");
            resetDisasterButtons();
            selectedDisasterCondition = "";
        });

        // --- SMS hotlines ---
        root.btnGlobeSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09773289562"));
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");
            startActivity(intent);
        });

        root.btnSmartSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:09395131408"));
            intent.putExtra("sms_body", "Hello, Kialangan ko po ng tulong Medical.");
            startActivity(intent);
        });

        // it redirect to log in layout
        navDrawerBinding.logout.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LogInActivity.class));
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(root.drawerLayout);
    }

    // Drawer open/close
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

    // Reset buttons
    private void resetMedicalButtons() {
        root.btnHeartAttack.setBackgroundResource(R.drawable.btn_flat_red_bg);
        root.btnHighFever.setBackgroundResource(R.drawable.btn_flat_red_bg);
    }

    private void resetVehicularButtons() {
        root.btnOneCasualty.setBackgroundResource(R.drawable.btn_flat_red_bg);
        root.btnMultipleCasualty.setBackgroundResource(R.drawable.btn_flat_red_bg);
    }

    private void resetDisasterButtons() {
        root.btnEarthquake.setBackgroundResource(R.drawable.btn_flat_red_bg);
        root.btnTyphoon.setBackgroundResource(R.drawable.btn_flat_red_bg);
    }
}