package com.bcit.lukaszbednarek.lab5.lecture6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bcit.lukaszbednarek.lab5.lecture6.pager2_transformers.pager2_transformers.Pager2_ClockSpinTransformer;
import com.bcit.lukaszbednarek.lab5.lecture6.pager2_transformers.pager2_transformers.Pager2_TossTransformer;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cartoon[] cartoons = {
                new Cartoon("Sandy", R.drawable.sandy, "squirrel"),
                new Cartoon("Squidward", R.drawable.squidward, "squid"),
                new Cartoon("Gary", R.drawable.gary, "snail")
        };

        ViewPager2 viewPager2 = findViewById(R.id.viewPager_main);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, cartoons);
        viewPager2.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout_main);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(cartoons[position].getName());
            }
        });

        tabLayoutMediator.attach();

        viewPager2.setPageTransformer(new Pager2_TossTransformer());

        setUpSpinner();

    }

    void setUpSpinner() {
        // Lukasz Bednarek
        Spinner spinner = findViewById(R.id.spinner_main);
        List<String> countries = new ArrayList<>();
        countries.add("Canada");
        countries.add("Norway");
        countries.add("Germany");
        countries.add("Japan");
        countries.add("India");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countries);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // set data

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                System.out.println(countries.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner.setAdapter(arrayAdapter);
    }
}