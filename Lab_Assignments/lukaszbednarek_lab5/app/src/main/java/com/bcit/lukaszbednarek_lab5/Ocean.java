package com.bcit.lukaszbednarek_lab5;

import java.io.Serializable;

public class Ocean implements Serializable {
    private String name;
    private int id;

    public Ocean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
