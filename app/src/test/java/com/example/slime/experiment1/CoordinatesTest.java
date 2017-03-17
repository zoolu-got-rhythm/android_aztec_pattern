package com.example.slime.experiment1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Slime on 17/03/2017.
 */
public class CoordinatesTest {
    private Coordinates c;
    @Before
    public void setup() throws Exception{
        this.c = new Coordinates(5,5);
    }

    @Test
    public void testPlot() throws Exception {
        Coordinates newC = this.c.plot(new Coordinates(5,5));
        int x = newC.getX();
        int y = newC.getY();
        assertEquals(20, x + y);
        newC = this.c.plot(new Coordinates(0,-1));
        x = newC.getX();
        y = newC.getY();
        assertEquals(9, x + y);
        assertNotEquals(this.c, newC); // make sure object reference are different
    }

    @Test
    public void testMove() throws Exception {
        this.c.move(1,1);
        int x = this.c.getX();
        int y = this.c.getY();
        assertEquals(12, x + y);
    }

    @Test
    public void testPlotMultiple() throws Exception {
        ArrayList<Coordinates> cos = new ArrayList<>();
        cos.add(new Coordinates(5,5));

        for(int i = 0; i <= 5; i++){
            Coordinates prev = new Coordinates(cos.get(cos.size() - 1));
            cos.add(prev.plot(new Coordinates(0, -1)));
        }

        for(Coordinates co : cos){
            System.out.println(co.getX() + ", " + co.getY());
            System.out.println(co);
        }
    }

    @Test
    public void testGetY() throws Exception {

    }
}