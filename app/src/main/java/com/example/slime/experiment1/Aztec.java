package com.example.slime.experiment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Slime on 17/03/2017.
 */
public class Aztec {

    private Coordinates origin;
    private int length = 2;
    private ArrayList<Coordinates> currentPattern;
    private Map<String, Coordinates> dir;
    private Coordinates prev;
    private int lines = 0;

    private int i = 0;

    public Aztec(Coordinates origin){
        this.origin = origin;
        this.dir = new HashMap<String, Coordinates>();
        this.currentPattern = new ArrayList<>();
        this.dir.put("n", new Coordinates(0, -1));
        this.dir.put("e", new Coordinates(1, 0));
        this.dir.put("s", new Coordinates(0, 1));
        this.dir.put("w", new Coordinates(-1, 0));
        this.prev = this.origin;
        this.currentPattern.add(this.origin);
    }

    public void move(){
        moveDirection();

        // i = to number of cubes in a line
        if(i == length) {
            lines++;
            if(lines % 2 == 0 && lines != 0){
                length += 30;
            }

            if(lines == 4){
                lines = 0;
            }

            i = 0;
        }

        i++;

        System.out.println(i);
    }

    public void moveDirection(){
        switch (this.lines + 1){
            case 1: this.currentPattern.add(this.prev.plot(this.dir.get("n")));
                break;
            case 2: this.currentPattern.add(this.prev.plot(this.dir.get("e")));
                break;
            case 3: this.currentPattern.add(this.prev.plot(this.dir.get("s")));
                break;
            case 4: this.currentPattern.add(this.prev.plot(this.dir.get("w")));
                break;
        }

        // get the last element and point prev reference to it in memory
        this.prev = this.getCurrentPattern().get(this.currentPattern.size() - 1);

    }

    public ArrayList<Coordinates> getCurrentPattern() {
        return currentPattern;
    }
}
