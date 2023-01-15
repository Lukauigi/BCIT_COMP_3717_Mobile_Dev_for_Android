package com.bcit.lukaszbednarek.lab5.lecture7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // adds up icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // switches default menu layout with menu_actionbar
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // prints to console item title when item clicked (selected)

        switch (item.getItemId()) {
            case android.R.id.home: // home button click
                // start a new activity
                // remove activity from stack (kill activity, calls onDestroy)
                // goes back to previous activity (back button)
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}