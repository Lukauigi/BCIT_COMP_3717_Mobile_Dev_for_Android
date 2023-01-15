package com.bcit.lukaszbednarek_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FactsActivity extends AppCompatActivity {

    public static final int NAME = 0;
    public static final int INFO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);

        Intent intent = getIntent();
        ArrayList<String> breedInfo = intent.getStringArrayListExtra(BreedsActivity.BREED_DATA);

        TextView description = findViewById(R.id.textView_facts_description);
        ImageView imageView = findViewById(R.id.imageView_facts_picture);

        description.setText(breedInfo.get(INFO));

        if (breedInfo.get(NAME).compareTo(Species.CENTRAL_US_COYOTE_KEY) == 0) {
            imageView.setImageResource(R.drawable.central_us_coyote);
        }

        else if (breedInfo.get(NAME).compareTo(Species.WESTERN_COYOTE_KEY) == 0) {
            imageView.setImageResource(R.drawable.western_coyote);
        }

        else if (breedInfo.get(NAME).compareTo(Species.EASTERN_COYOTE_KEY) == 0) {
            imageView.setImageResource(R.drawable.eastern_coyote);
        }

        else if (breedInfo.get(NAME).compareTo(Species.MASAI_LION_KEY) == 0) {
            imageView.setImageResource(R.drawable.masai_lion);
        }

        else if (breedInfo.get(NAME).compareTo(Species.TRANSVAAL_LION_KEY) == 0) {
            imageView.setImageResource(R.drawable.transvaal_lion);
        }

        else if (breedInfo.get(NAME).compareTo(Species.ETHIOPIAN_LION_KEY) == 0) {
            imageView.setImageResource(R.drawable.ethiopian_lion);
        }
    }
}