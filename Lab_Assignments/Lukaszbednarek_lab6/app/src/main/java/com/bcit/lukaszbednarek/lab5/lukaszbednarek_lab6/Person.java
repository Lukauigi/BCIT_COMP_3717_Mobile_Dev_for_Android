package com.bcit.lukaszbednarek.lab5.lukaszbednarek_lab6;

import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String location;

    Person(final String firstName, final String lastName, final String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }
}
