package com.bcit.lukaszbednarek.lab5.lukaszbednarek_midterm;

import java.io.Serializable;

public class Hippo implements Serializable {

    private String name;
    private int age;
    private String food;
    private int resId;

    Hippo(String name, int age, String food, int resId) {
        this.age = age;
        this.name = name;
        this.food = food;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFood() {
        return food;
    }

    public int getResId() {
        return resId;
    }
}
