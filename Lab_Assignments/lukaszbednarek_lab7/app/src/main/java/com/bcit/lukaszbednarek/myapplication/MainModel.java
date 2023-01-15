package com.bcit.lukaszbednarek.myapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class MainModel {

    private OffLeashParks.Root root;

    MainModel(final String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.root = mapper.readValue(jsonString, OffLeashParks.Root.class);
    }

    public List<OffLeashParks.Record> getData() {
        return root.records;
    }
}
