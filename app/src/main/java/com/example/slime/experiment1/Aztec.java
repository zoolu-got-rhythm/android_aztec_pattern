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
        this.currentPattern.add(this.origin);
    }

    public void move(){
        if(lines % 2 == 0 && lines != 0)
            length+=25;
        //System.out.println(lines);

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
        // System.out.println("ran");
        switch (this.lines + 1){
            case 1: this.currentPattern.add(this.prev.plot(this.dir.get("n")));
                    System.out.println("n");
                    break;
            case 2: this.currentPattern.add(this.prev.plot(this.dir.get("e")));
                System.out.println("e");

                break;
            case 3: this.currentPattern.add(this.prev.plot(this.dir.get("s")));
                System.out.println("s");

                break;
            case 4: this.currentPattern.add(this.prev.plot(this.dir.get("w")));
                System.out.println("w");

                break;
        }

        // get the last element and point prev reference to it in memory
        this.prev = this.getCurrentPattern().get(this.currentPattern.size() - 1);

        System.out.println(this.prev.getX() + ", " + this.prev.getY());

//        for(Coordinates co : this.getCurrentPattern()){
//            System.out.println(co.getX() + "" + co.getY());
//        }
    }

    public ArrayList<Coordinates> getCurrentPattern() {
        return currentPattern;
    }
}
