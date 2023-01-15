package com.bcit.mvvmcats;

import android.graphics.Bitmap;

public class Cat {

    private Bitmap bitmap;
    private String fact;

    public Cat(Bitmap bitmap, String face){
        this.bitmap = bitmap;
        this.fact = face;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getFact() {
        return fact;
    }
}
