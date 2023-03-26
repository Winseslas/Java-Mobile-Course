package com.winseslas.refactoring.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.winseslas.refactoring.R;
import com.winseslas.refactoring.myFragments.books.BooksFragment;
import com.winseslas.refactoring.navigation.ui.login.LoginActivity;
import com.winseslas.refactoring.databinding.ActivityDrawerNavigationBinding;

public class DrawerNavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    // Initialization of the fragment
    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_container, new BooksFragment());
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Linking the layout
        ActivityDrawerNavigationBinding binding = ActivityDrawerNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialization of the toolbar
        setSupportActionBar(binding.appBarDrawerNavigation.toolbar);
        binding.appBarDrawerNavigation.toolbar.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        // Initialization of the side menu
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.findItem(R.id.nav_login);
        menuItem.setOnMenuItemClickListener(item -> {
            // Launching the connection activity
            Intent registerActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(registerActivity);
            finish();
            return true;
        });

        // Navigation configuration
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_favorite, R.id.nav_search, R.id.nav_about, R.id.nav_contact)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_drawer_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Initialization of the fragment
        initFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds it ems to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_drawer_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}