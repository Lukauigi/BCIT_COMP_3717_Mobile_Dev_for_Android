package com.bcit.lukaszbednarek_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM_NUMBER_GENERATOR = new Random();
    public static final Integer COLOUR_INDICES_RANGE = 2;
    public static final String SONG_DATA = "com.bcit.lukaszbednarek_lab2.DATA";

    public static final String SONG_ONE = "Xenoblade Chronicles - Mechanical Rhythm";
    public static final String SONG_TWO = "Donkey Kong Country - Voices of the Temple";
    public static final String SONG_THREE = "Final Fantasy VI - Dancing Mad";
    public static final String SONG_FOUR = "Super Mario Galaxy - Space Fantasy";
    public static final String SONG_FIVE = "The Legend Of Zelda: Breath of the Wild - " +
                                                                        "Dark Beast Ganon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] startupColours = new int[]{ getColor(R.color.deep_blue),
                                         getColor(R.color.pop_green),
                                         getColor(R.color.orange)};

        changeColourOnStartup(startupColours);
    }

    public void goToSongListOne(final View view) {
        Intent intent = new Intent(this, SongsActivity.class);
        ArrayList<String> songs = new ArrayList<>();
        songs.add(SONG_ONE);
        songs.add(SONG_TWO);
        songs.add(SONG_THREE);
        songs.add(SONG_FOUR);
        songs.add(SONG_FIVE);
        intent.putStringArrayListExtra(SONG_DATA, songs);
        startActivity(intent);
    }

    public void goToSongListTwo(final View view) {
        Intent intent = new Intent(this, SongsActivity.class);
        startActivity(intent);
    }

    public void changeColourOnStartup(final int[] colours) {
        final TextView mainText = findViewById(R.id.textView_main_song_title);
        final Button songOneButton = findViewById(R.id.button_main_song_one);
        final Button songTwoButton = findViewById(R.id.button_main_song_two);

        final int firstRandomColour = RANDOM_NUMBER_GENERATOR.nextInt(COLOUR_INDICES_RANGE + 1);
        mainText.setTextColor(colours[firstRandomColour]);

        int secondRandomColour = RANDOM_NUMBER_GENERATOR.nextInt(COLOUR_INDICES_RANGE + 1);
        while (secondRandomColour == firstRandomColour) {
            secondRandomColour = RANDOM_NUMBER_GENERATOR.nextInt(COLOUR_INDICES_RANGE + 1);
        }
        songOneButton.setBackgroundColor(colours[secondRandomColour]);

        int thirdRandomColour = RANDOM_NUMBER_GENERATOR.nextInt(COLOUR_INDICES_RANGE + 1);
        while (thirdRandomColour == firstRandomColour || thirdRandomColour == secondRandomColour) {
            thirdRandomColour = RANDOM_NUMBER_GENERATOR.nextInt(COLOUR_INDICES_RANGE + 1);
        }
        songTwoButton.setBackgroundColor(colours[thirdRandomColour]);
    }


}