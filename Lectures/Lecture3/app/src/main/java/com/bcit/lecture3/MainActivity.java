package com.bcit.lecture3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFECYCLE_MAIN", "onCreate");

        if (savedInstanceState != null) {
            Log.d("LIFECYCLE_MAIN0", "savedInstanceState is not null");
        } else {
            Log.d("LIFECYCLE_MAIN", "savedInstanceState is null");
        }
    }

    public void goToInfo(View view) {
        Bundle extras = new Bundle();
        Intent intent = new Intent(this, InfoActivity.class);

        extras.putString("Key", "Value");
        extras.putString("This is a key", "This is a value");

        intent.putExtras(extras); // pass a bundle (its like a hashmap, can send more data)

        startActivity(intent);
    }

    public void getEditText(View view) {
        EditText editText = findViewById(R.id.editText_main);
        str = editText.getText().toString();
        // 49:30 tldr: UI elements will not be preserved when screen rotated
    }

    public void setEditText(View view) {
        TextView textView = findViewById(R.id.textView_main);

        if (str == null || str.length() == 0) {
            textView.setText("The string is null");
        } else {
            textView.setText(str);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE_MAIN", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE_MAIN", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE_MAIN", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE_MAIN", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE_MAIN", "onDestroy");
    }
}