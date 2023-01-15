package com.bcit.lukaszbednarek.lab5.lukaszbednarek_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Hippo jerry = new Hippo("Jerry", 7, "Peanuts", R.drawable.hippo1);
        Hippo matilda = new Hippo("Matilda", 2, "Bananas", R.drawable.hippo2);
        Hippo allison = new Hippo("Allison", 12, "Coconuts", R.drawable.hippo3);
        Hippo craig = new Hippo("Craig", 2, "Potatoes", R.drawable.hippo4);

        final ArrayList<Hippo> hippos = createHippoList(jerry,
                matilda, allison, craig);

        fragmentTransaction.replace(R.id.fragmentContainerView_main_preview,
                PreviewFragment.newInstance(jerry));
        fragmentTransaction.commit();

        setUpSpinner(hippos);

        Button contactUs = findViewById(R.id.button_main_contact);
        contactUs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransactionContact = getSupportFragmentManager().beginTransaction();
                fragmentTransactionContact.replace(R.id.fragmentContainerView_main_preview,
                        new ContactFragment());
                fragmentTransactionContact.commit();
            }
        });
    }

    private void setUpSpinner(final ArrayList<Hippo> hippoList) {
        ArrayList<String> hippoNames = new ArrayList<>();
        for (int i = 0; i < hippoList.size(); i++) {
            hippoNames.add(hippoList.get(i).getName());
        }
        Spinner spinner = findViewById(R.id.spinner_main_preview_hippos);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, hippoNames);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView_main_preview,
                        PreviewFragment.newInstance(hippoList.get(i)));
                fragmentTransaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        spinner.setAdapter(arrayAdapter);
    }

    public ArrayList<Hippo> createHippoList(final Hippo... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

}