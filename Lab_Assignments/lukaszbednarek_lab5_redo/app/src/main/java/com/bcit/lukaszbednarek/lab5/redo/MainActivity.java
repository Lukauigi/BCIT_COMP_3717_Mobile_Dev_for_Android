package com.bcit.lukaszbednarek.lab5.redo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /* Pacific Ocean Facts */

    public static final String PACIFIC_OCEAN_FACT_ONE = "The Pacific Ocean is the " +
            "largest ocean and contains 50.1% of all ocean water on our planet.";
    public static final String PACIFIC_OCEAN_FACT_TWO = "The deepest part of the world’s oceans " +
            "is in the Mariana Trench in the western Pacific Ocean.";
    public static final String PACIFIC_OCEAN_FACT_THREE = "The Pacific Ocean is 63.8 million " +
            "square miles (165.25 million square kilometers)";

    /* Atlantic Ocean Facts */

    public static final String ATLANTIC_OCEAN_FACT_ONE = "The Atlantic Ocean is the second " +
            "largest ocean and contains 23.3% of all ocean water on our planet.";
    public static final String ATLANTIC_OCEAN_FACT_TWO = "The United States is less than one " +
            "sixth the size of the Atlantic Ocean.";
    public static final String ATLANTIC_OCEAN_FACT_THREE = "Off the coast of Namibia in " +
            "southern Africa, diamond deposits have been located in the Atlantic Ocean";

    /* Indian Ocean Facts */

    public static final String INDIAN_OCEAN_FACT_ONE = "The Indian Ocean is the third " +
            "largest ocean and contains 19.8% of all ocean water on our planet.";
    public static final String INDIAN_OCEAN_FACT_TWO = "Waters in the Indian Ocean have one " +
            "of the lowest oxygen content of the world owing to greater evaporation rate in " +
            "this ocean than its run off or precipitation influx.";
    public static final String INDIAN_OCEAN_FACT_THREE = "A rather interesting bit of " +
            "information on the Indian Ocean is its limited marine animal life which is due " +
            "to a higher water temperature of this ocean.";

    static int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GeoFragments - By Lukasz Bednarek");
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();


        // create arrays of facts
        final ArrayList<String> pacificOceanFacts = createFactList(PACIFIC_OCEAN_FACT_ONE,
                PACIFIC_OCEAN_FACT_TWO, PACIFIC_OCEAN_FACT_THREE);
        final ArrayList<String> atlanticOceanFacts = createFactList(ATLANTIC_OCEAN_FACT_ONE,
                ATLANTIC_OCEAN_FACT_TWO, ATLANTIC_OCEAN_FACT_THREE);
        final ArrayList<String> indianOceanFacts = createFactList(INDIAN_OCEAN_FACT_ONE,
                INDIAN_OCEAN_FACT_TWO, INDIAN_OCEAN_FACT_THREE);

        final Ocean pacificOcean = new Ocean(OceanType.PACIFIC.name(), R.drawable.pacific_ocean, pacificOceanFacts);
        final Ocean atlanticOcean = new Ocean(OceanType.ATLANTIC.name(), R.drawable.atlantic_ocean, atlanticOceanFacts);
        final Ocean indianOcean = new Ocean(OceanType.INDIAN.name(), R.drawable.indian_ocean, indianOceanFacts);

        fragmentManager.replace(R.id.fragmentContainerView_main_ocean, OceanFragment.newInstance(pacificOcean));
        fragmentManager.replace(R.id.fragmentContainerView_main_ocean_info, FactsFragment.newInstance(pacificOcean.getFacts()));
        fragmentManager.commit();

        Button next = findViewById(R.id.button_main_next_ocean);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                if (count == 1) {
                    fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean, OceanFragment.newInstance(atlanticOcean));
                    fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean_info, FactsFragment.newInstance(atlanticOcean.getFacts()));
                    count += 1;
                } else if (count == 2) {
                    fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean, OceanFragment.newInstance(indianOcean));
                    fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean_info, FactsFragment.newInstance(indianOcean.getFacts()));
                    count += 1;
                } else if (count == 3) {
                    fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean, OceanFragment.newInstance(pacificOcean));
                    fragmentTransaction.replace(R.id.fragmentContainerView_main_ocean_info, FactsFragment.newInstance(pacificOcean.getFacts()));
                    count = 1;
                }
                fragmentTransaction.commit();
            }
        });
    }

    public ArrayList<String> createFactList(String... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}