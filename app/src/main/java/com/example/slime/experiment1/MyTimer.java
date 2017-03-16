package com.example.slime.experiment1;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Slime on 12/03/2017.
 */
public class MyTimer {
    private ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(1);
    private int frameRateMillaSeconds;
    private Magic magic;


    public MyTimer(Magic m){
        this(1000 / 30, m);
    }

    public MyTimer(int millaSecs, Magic m){
        this.frameRateMillaSeconds = millaSecs;
        this.magic = m;
    }

    public void start(){
        s.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                magic.wipe();
                magic.draw();
            }
        }, frameRateMillaSeconds, frameRateMillaSeconds, TimeUnit.MILLISECONDS);
    }

    public void stop(){
        s.shutdown();
    }
}

interface DoWork{
    void doStuff();
}
