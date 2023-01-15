package com.bcit.lukaszbednarek.lab5.lukaszbednarek_lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().setTitle("Firestore Mappy - By Lukasz Bednarek");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = FirebaseFirestore.getInstance();
        getPeople();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // switches default menu layout with menu_actionbar
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void getPeople() {
        List<Person> people = new ArrayList<Person>();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Debug", document.getData().toString());

                                people.add(
                                        new Person(
                                                document.getData().get("firstName").toString(),
                                                document.getData().get("lastName").toString(),
                                                document.getData().get("location").toString()
                                        )
                                );
                            }
                        } else {
                            Log.w("Debug", "Error getting documents.", task.getException());
                        }
                        Person[] peps = people.toArray(new Person[people.size()]);

                        RecyclerView recyclerView = findViewById(R.id.recyclerView_info);

                        PersonAdapter personAdapter = new PersonAdapter(peps);
                        recyclerView.setAdapter(personAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    }
                });
    }
}