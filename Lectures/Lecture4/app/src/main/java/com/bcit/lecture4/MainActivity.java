package com.bcit.lecture4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // do this when there are many btns
//    View.OnClickListener myListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//        }
//    };
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_main_example); //get button from layout

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click that shit");
            }
        });

        // can put myListener in param if using anonymous class above
        // button.setOnClickListener(this::onClick); // button listens to inner class
//        button.setOnClickListener(this::onClick);

        setUpRecyclerView();

    }

    public void setUpRecyclerView() {
        RecyclerView rv = findViewById(R.id.recyclerView_main_example);

        String[] students = {"billy jones", "sarah seawolf", "anny winnie"};

        StudentAdapter adapter = new StudentAdapter(students);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    public void clickMe(final View view) {
        // make event listener through layout design
    }

    // with this method, pass keyword: this ; to button listener param above
    public void onClick(View view) {
        System.out.println("you click the button");
    }

    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            System.out.println("you clicked the button!");
        }
    }
}