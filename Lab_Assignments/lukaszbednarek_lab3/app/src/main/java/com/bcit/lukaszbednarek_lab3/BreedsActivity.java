package com.bcit.lukaszbednarek_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class BreedsActivity extends AppCompatActivity {

    private Bundle breedData;
    public static final String BREED_DATA = "com.bcit.lukaszbednarek_lab3.BREED_DATA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);

        Intent intent = getIntent();
        Bundle breeds = intent.getExtras();
        String[] breedNames = breeds.keySet().toArray(new String[3]);
        System.out.println(breedNames[0]);

        Button firstSelection = findViewById(R.id.button_breeds_first_selection);
        Button secondSelection = findViewById(R.id.button_breeds_second_selection);
        Button thirdSelection = findViewById(R.id.button_breeds_third_selection);

        firstSelection.setText(breedNames[0]);
        secondSelection.setText(breedNames[1]);
        thirdSelection.setText(breedNames[2]);

        breedData = breeds;

    }

    public void toFactsActivity(final View view) {
        Intent intent = new Intent(this, FactsActivity.class);
        String[] breedNames = breedData.keySet().toArray(new String[3]);
        Button button = (Button) view;

        for (String name : breedNames) {
            if (name.compareTo(button.getText().toString()) == 0) {
                ArrayList<String> info = new ArrayList<>();
                info.add(name);
                info.add(breedData.getString(name));
                intent.putStringArrayListExtra(BREED_DATA, info);
                startActivity(intent);
            }
        }

    }


}