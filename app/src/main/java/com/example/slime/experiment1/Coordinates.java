package com.example.slime.experiment1;

/**
 * Created by Slime on 17/03/2017.
 */
// unit test this component
public class Coordinates{
    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinates plot(Coordinates other){
        return new Coordinates(this.getX() + other.getX(), this.getX() + other.getY());
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}