package com.bcit.lukaszbednarek.lab5.lukaszbednarek_lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    String mapLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Firestore Mappy - By Lukasz Bednarek");

        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.fragmentContainerView_main_map, new LocationFragment());
        fragmentManager.commit();

        db = FirebaseFirestore.getInstance();
    }

    public void addPerson(final View view) {

        EditText firstNameField = findViewById(R.id.editText_main_firstName);
        EditText lastNameField = findViewById(R.id.editText_main_lastName);

        String firstName = firstNameField.getText().toString();
        String lastName = lastNameField.getText().toString();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !this.mapLocation.isEmpty()) {

            Person person = new Person(firstName, lastName, this.mapLocation);

            db.collection("users")
                    .add(person)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("Debug", "DocumentSnapshot added with ID: "
                                    + documentReference.get());
                            Intent intent = new Intent(getBaseContext(), InfoActivity.class);
                            startActivity(intent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("Debug", "Error adding document", e);
                        }
                    });
        }
    }

    public void setMapLocation(final String location) {
        this.mapLocation = location;
    }
}