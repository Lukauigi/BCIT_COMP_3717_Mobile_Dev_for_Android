package com.bcit.ca5;

import java.io.Serializable;

public class Cartoon implements Serializable {

    private String name;
    private String occupation;

    public Cartoon(String name, String occupation) {
       this.name = name;
       this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
}
