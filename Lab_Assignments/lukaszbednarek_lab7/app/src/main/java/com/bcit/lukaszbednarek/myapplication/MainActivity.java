package com.bcit.lukaszbednarek.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Dogs are the MVP - By Lukasz Bednarek");

        Future<String> request = CreateHttpRequestForJson("https://opendata.vancouver.ca/api/records/1.0/search/?dataset=dog-off-leash-parks&q=&facet=geo_local_area");

        MainModel model = null;
        String jsonString = null;

        // try to get json string from api link
        try {
            jsonString = request.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // try to construct MainModel with all info from json
        try {
            model = new MainModel(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // constructs the presenter with this view and parsed json (model) and displays info w/ method
        if (model != null) {
            MainPresenter presenter = new MainPresenter(this, model);
            presenter.getDataFromModel();
        } else {
            Log.e("MainActivity", "Could not create MainModel object.");
        }
    }

    /* Async operation to get json string */
    public Future<String> CreateHttpRequestForJson(String url) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        HttpHandler<String> httpHandler = new HttpHandler<>(url, false);
        return executorService.submit(httpHandler);
    }

    /* Reinflate the recyclerview with park areas */
    @Override
    public void onUpdateRecycler(List<OffLeashParks.Record> areas) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView_main);
        OffLeashDogParksAdapter adapter = new OffLeashDogParksAdapter(areas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}