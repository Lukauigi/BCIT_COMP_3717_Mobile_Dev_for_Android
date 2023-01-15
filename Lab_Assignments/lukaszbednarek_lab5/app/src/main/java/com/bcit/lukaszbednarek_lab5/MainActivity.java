package com.bcit.lukaszbednarek_lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GeoFragments - By Lukasz Bednarek");
        setContentView(R.layout.activity_main);
    }

    public void swapFragment(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (count == 1) {
            Ocean atlanticOcean = new Ocean(OceanType.ATLANTIC.name(), R.drawable.atlantic_ocean);
            fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean, new FactsFragment());
            fragmentTransaction.commit();
            count = 2;
        } else if (count == 2) {
            Ocean atlanticOcean = new Ocean(OceanType.ATLANTIC.name(), R.drawable.atlantic_ocean);
            fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean, OceanFragment.newInstance(atlanticOcean));
            fragmentTransaction.commit();
            count = 3;
        }
    }
}