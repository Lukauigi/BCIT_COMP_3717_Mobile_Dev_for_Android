package com.bcit.lukaszbednarek.lab5.lecture6;

import java.io.Serializable;

public class Cartoon implements Serializable {

    private String name;
    private int resourceId;
    private String species;

    public Cartoon(String name, int resourceId, String species) {
        this.name = name;
        this.resourceId = resourceId;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getSpecies() {
        return species;
    }
}
