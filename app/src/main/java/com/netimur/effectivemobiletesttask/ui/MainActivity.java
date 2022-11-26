package com.netimur.effectivemobiletesttask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.netimur.effectivemobiletesttask.R;

final public class MainActivity extends AppCompatActivity {
    private boolean isBottomNavigationInitialized = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.fragment_container_view_tag);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        isBottomNavigationInitialized = true;
    }


    public boolean isBottomNavigationInitialized() {
        return isBottomNavigationInitialized;
    }
}