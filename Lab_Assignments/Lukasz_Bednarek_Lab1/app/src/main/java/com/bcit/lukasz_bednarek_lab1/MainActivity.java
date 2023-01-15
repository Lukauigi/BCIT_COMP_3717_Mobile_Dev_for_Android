package com.bcit.lukasz_bednarek_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String NO_INPUT = "Enter some text!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setTextAndColour(final int colourCode) {
        final EditText inputField = findViewById(R.id.edit_text_main_input);
        final TextView dynamicDisplay = findViewById(R.id.text_view_main_dynamic_colour_text);
        final String text = inputField.getText().toString().trim();

        if (text.isEmpty()) {
            dynamicDisplay.setText(NO_INPUT);
            dynamicDisplay.setTextColor(Color.BLACK);
        } else {
            dynamicDisplay.setText(text);
            dynamicDisplay.setTextColor(colourCode);
        }
    }

    public void setBlueText(final View view) {
        setTextAndColour(Color.BLUE);
    }

    public void setRedText(final View view) {
        setTextAndColour(Color.RED);
    }

    public void setGreenText(final View view) {
        setTextAndColour(Color.GREEN);
    }

    public void clearInputField(final View view) {
        final EditText input = findViewById(R.id.edit_text_main_input);
        input.setText("");
    }
}