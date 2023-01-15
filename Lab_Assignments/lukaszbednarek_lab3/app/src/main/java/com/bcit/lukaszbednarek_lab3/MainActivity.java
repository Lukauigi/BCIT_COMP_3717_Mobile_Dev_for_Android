package com.bcit.lukaszbednarek_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toBreedsActivity(final View view) {
        Intent intent = new Intent(this, BreedsActivity.class);
        Bundle breeds = new Bundle();

        if (view.getId() == R.id.button_main_coyote) {
            breeds.putString(Species.WESTERN_COYOTE_KEY, Species.WESTERN_COYOTE_INFO);
            breeds.putString(Species.CENTRAL_US_COYOTE_KEY, Species.CENTRAL_US_COYOTE_INFO);
            breeds.putString(Species.EASTERN_COYOTE_KEY, Species.EASTERN_COYOTE_INFO);

            intent.putExtras(breeds);
            startActivity(intent);
        } else if (view.getId() == R.id.button_main_lion) {
            breeds.putString(Species.MASAI_LION_KEY, Species.MASAI_LION_INFO);
            breeds.putString(Species.TRANSVAAL_LION_KEY, Species.TRANSVAAL_LION_INFO);
            breeds.putString(Species.ETHIOPIAN_LION_KEY, Species.ETHIOPIAN_LION_INFO);

            intent.putExtras(breeds);
            startActivity(intent);
        }
    }
}