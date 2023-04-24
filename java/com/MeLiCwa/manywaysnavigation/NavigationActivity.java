package com.MeLiCwa.manywaysnavigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.MeLiCwa.manywaysnavigation.databinding.ActivityNavigationBinding;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);
        setNavigationDrawer();
    }

    private void setNavigationDrawer() {
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_favs, R.id.nav_settings).build();

        //Initialize NavController.
        NavController navController = Navigation.findNavController(this, R.id.text_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }
}

