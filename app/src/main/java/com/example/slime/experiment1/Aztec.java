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
    // private Coordinates current;
    private int lines = 0;

    public Aztec(Coordinates origin){
        this.origin = origin;
        this.dir = new HashMap<String, Coordinates>();
        this.currentPattern = new ArrayList<>();
        this.dir.put("n", new Coordinates(0, -1));
        this.dir.put("e", new Coordinates(1, 0));
        this.dir.put("s", new Coordinates(0, 1));
        this.dir.put("w", new Coordinates(-1, 0));
        this.prev = this.origin;
        //this.currentPattern.add(new Coordinates(5, 2));
        this.currentPattern.add(this.prev);
    }

    public void move(){
        if(lines % 2 == 0 && lines != 0)
            length++;
        System.out.println(lines);

        for(int i = 0; i < length; i++){
            moveDirection();
        }

        if(lines == 4){
            lines = 0;
        }else{
            lines++;
        }
    }

    public void moveDirection(){
        System.out.println("ran");
        switch (this.lines){
            case 1: currentPattern.add(this.prev.plot(this.dir.get("n")));
                    break;
            case 2: currentPattern.add(this.prev.plot(this.dir.get("e")));
                    break;
            case 3: currentPattern.add(this.prev.plot(this.dir.get("s")));
                    break;
            case 4: currentPattern.add(this.prev.plot(this.dir.get("w")));
                    break;
        }

        // get the last element and point prev reference to it
        this.prev = currentPattern.get(currentPattern.size() - 1);
    }

    public ArrayList<Coordinates> getCurrentPattern() {
        return currentPattern;
    }
}
