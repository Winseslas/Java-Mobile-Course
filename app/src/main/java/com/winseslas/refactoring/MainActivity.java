package com.winseslas.refactoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.winseslas.refactoring.navigation.DrawerNavigationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("You are welcome");

        Button getStartingButton = findViewById(R.id.getStarting);
        getStartingButton.setOnClickListener(v -> {
            Intent registerActivity = new Intent(getApplicationContext(), DrawerNavigationActivity.class);
            startActivity(registerActivity);
            finish();
        });
    }
}