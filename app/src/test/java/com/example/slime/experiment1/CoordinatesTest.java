package com.example.slime.experiment1;

import org.junit.Before;
import org.junit.Test;

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
    public void testGetX() throws Exception {

    }

    @Test
    public void testGetY() throws Exception {

    }
}