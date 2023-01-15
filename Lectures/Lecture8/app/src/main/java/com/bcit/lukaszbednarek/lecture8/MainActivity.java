package com.bcit.lukaszbednarek.lecture8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a Future from a url of api
        Future<String> request = CreateHttpRequestForJson("https://api4all.azurewebsites.net/api/people/");

        String str = null;

        try {
            str = request.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("**********" + str);

        Toon[] toons = ParseJson(str);
        RecyclerView recyclerView = findViewById(R.id.recyclerView_main);
        ToonsAdapter toonsAdapter = new ToonsAdapter(toons);
        recyclerView.setAdapter(toonsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public Future<String> CreateHttpRequestForJson(String url) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        HttpHandler<String> httpHandler = new HttpHandler<>(url, false);
        return executorService.submit(httpHandler);
    }

    public Toon[] ParseJson(String json) {
        if (json != null) {
            json = "{\"toons\":" + json + "}";
            Gson gson = new Gson();
            ToonsBase base = gson.fromJson(json, ToonsBase.class);
            return base.getToons();
        } else {
            Log.e("MainActivity", "json is null");
            return null;
        }
    }
}