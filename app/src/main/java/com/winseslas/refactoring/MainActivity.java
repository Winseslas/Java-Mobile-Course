package com.winseslas.refactoring;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.winseslas.refactoring.navigation.DrawerNavigationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("You are welcome");

        if (!isConnected()) {
            // If the device is not connected to the Internet, display a Cupertino PopUp that asks the user to connect and close the application.
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("No Internet Connection");
            builder.setMessage("Please connect to the internet and try again.");
            builder.setPositiveButton("OK", (dialog, which) -> finish());
            builder.show();
        } else {
            // If the device is connected to the Internet, set the button to start the DrawerNavigationActivity.
            Button getStartingButton = findViewById(R.id.getStarting);
            getStartingButton.setOnClickListener(v -> {
                Intent registerActivity = new Intent(getApplicationContext(), DrawerNavigationActivity.class);
                startActivity(registerActivity);
                finish();
            });
        }
    }

    private boolean isConnected() {
        // Check if the device is connected to the Internet.
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}