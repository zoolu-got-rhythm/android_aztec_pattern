package com.example.slime.experiment1;

import android.util.Log;

/**
 * Created by Slime on 12/03/2017.
 */
public class Stuff implements Magic {
    public Stuff(){}

    public void draw(){
        Log.d("draw", "drawing");
    }

    public void wipe(){
        Log.d("wipe", "wiping");
    }
}
