package com.bcit.mvvmcats;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.ScriptGroup;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

enum RequestType {
    IMAGE,
    JSON,
}

public class CatRepository<T> {

    String URL = "https://api.thecatapi.com/v1/images/search";

    public CatRepository() {}

    public Future<Bitmap> executeRequest() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> jsonResult = executor.submit(makeRequest(RequestType.JSON, URL));

        return executor.submit(makeRequest(RequestType.IMAGE, jsonResult.get()));
    }

    public Callable makeRequest(RequestType type, String URL) {

        return new Callable() {
            @Override
            public T call() {
                T response = null;
                try {
                    java.net.URL url = new URL(URL);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET"); //GET is default

                    //read the response
                    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    if (type == RequestType.JSON) {
                        response = (T)ParseImageUrlFromJson(convertStreamToString(inputStream));

                    }else if (type == RequestType.IMAGE){
                        response = (T) BitmapFactory.decodeStream(inputStream);
                    }

                    return response;

                } catch (Exception e) {
                    e.getMessage();
                    return null;
                }
            }
        };
    }

    String ParseImageUrlFromJson(String jsonStr) {

        if (jsonStr != null) {

            Gson gson = new Gson();
            System.out.println(jsonStr);
            CatBase.Root[] base = gson.fromJson(jsonStr, CatBase.Root[].class);

            return base[0].url;

        } else {
            Log.e("MainActivity", "json is null");
            return null;
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private List<String> convertRawFile(InputStream is){

        List<String> strings = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = br.readLine()) != null){
                strings.add(line);
            }
            br.close();
        }catch (IOException e){}

        return strings;
    }

    public Cat getRandomCat(Context context) {

        InputStream inputStream = context.getResources().openRawResource(R.raw.catfacts);
        List<String> facts = convertRawFile(inputStream);

        Random random = new Random();
        String randomFact = facts.get(random.nextInt(facts.size()));

        Bitmap bitmapResult = null;
        try {
            bitmapResult = executeRequest().get(); //blocker method
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("repo", randomFact);

        return new Cat(bitmapResult, randomFact);
    }

}
