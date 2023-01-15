package com.bcit.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void doSomething(final View view) {
        System.out.println("Click recognizes function");
        TextView textview = findViewById(R.id.text_main);
        EditText editText = findViewById(R.id.editText_main);
        String aString = editText.getText().toString();
        textview.setText(aString);
    }

    public void changeTextColour(final View view) {
        // Lukasz Bednarek

        System.out.println("Colour change?");
        TextView text = findViewById(R.id.textColour_main);
        String string = "Learning is Fun!";
        text.setText(string);
        text.setTextColor(Color.BLUE);
    }

}