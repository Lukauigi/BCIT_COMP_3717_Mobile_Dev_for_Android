package com.bcit.lukaszbednarek.lab5.redo;

import java.io.Serializable;
import java.util.ArrayList;

public class Ocean implements Serializable {
    private final String name;
    private final int id;
    private ArrayList<String> facts;

    public Ocean(String name, int id, ArrayList<String> facts) {
        this.name = name;
        this.id = id;
        this.facts = facts;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getFacts() {
        return facts;
    }
}
