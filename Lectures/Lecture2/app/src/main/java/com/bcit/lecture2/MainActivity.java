package com.bcit.lecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_GENERIC = "com.bcit.lecture2.GENERICDATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        setUpSpinner();

        String string = getResources().getString(R.string.good_morning_string);
        System.out.println(string);

        File folder = new File(".").getAbsoluteFile();
        File[] listOfFiles = folder.listFiles();
    }

    public void printSomething(final View view) {
        Button btn = (Button)view;
        String btnText = btn.getText().toString();
        if (view.getId() == R.id.main_button_one) {
            System.out.println("clicked " + btnText + " yeah!");
        } else {
            System.out.println("clicked " + btnText + " woo!");
        }
    }

    public void goToInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(EXTRA_GENERIC, "pancakes");
        startActivity(intent);
    }

    public void openURL(final View view) {
        String url = "http://facebook.com";
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void passText(final View view) {
        // Lukasz Bednarek

        TextView textView = findViewById(R.id.textview_main_pass_text);
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(EXTRA_GENERIC, textView.getText());
        startActivity(intent);
    }

    void setUpSpinner() {
        Spinner spinner = findViewById(R.id.spinner_main);
        List<String> countries = new ArrayList<>();
        countries.add("Canada");
        countries.add("Norway");
        countries.add("Germany");
        countries.add("Japan");
        countries.add("India");

        // adapter, complex ones will be a class
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countries);

        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.animals, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // set data
        spinner.setAdapter(arrayAdapter);
    }
}
