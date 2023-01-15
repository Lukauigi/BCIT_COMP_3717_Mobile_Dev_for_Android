package com.bcit.lukaszbednarek_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);


        Intent intent = getIntent();
        ArrayList<String> songs = intent.getStringArrayListExtra(MainActivity.SONG_DATA);

        if (songs == null) {
            setUpSongTwoSpinner();
        } else {
            setUpSongOneSpinner(songs);
        }

    }

    private void setUpSongOneSpinner(final ArrayList<String> songList) {
        Spinner spinner = findViewById(R.id.spinner_songs_song_dropdown);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, songList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    private void setUpSongTwoSpinner() {
        Spinner spinner = findViewById(R.id.spinner_songs_song_dropdown);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.good_songs, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

}