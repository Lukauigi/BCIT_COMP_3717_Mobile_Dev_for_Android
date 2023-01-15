package com.bcit.ca5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static int Count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cartoon spongeCartoon = new Cartoon("Spongebob", "Fry cook");
        Cartoon starCartoon = new Cartoon("Patrick", "Unemployed");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragmentContainerView_Main, new StarFragment());
        fragmentTransaction.commit();

        Fragment spongeFragment = SpongeFragment.newInstance(spongeCartoon);
        Fragment starFragment = StarFragment.newInstance(starCartoon);
    }

    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (Count == 1) {
            fragmentTransaction.replace(R.id.fragmentContainerView_Main, new SpongeFragment());
            fragmentTransaction.commit();
            Count = 2;
        }
        else {
            fragmentTransaction.replace(R.id.fragmentContainerView_Main, new StarFragment());
            fragmentTransaction.commit();
            Count = 1;
        }
    }
}