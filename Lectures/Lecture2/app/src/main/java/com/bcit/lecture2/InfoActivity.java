package com.bcit.lecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String string = intent.getStringExtra(MainActivity.EXTRA_GENERIC);

        TextView textView = findViewById(R.id.textView_info);
        textView.setText(string);
    }
}