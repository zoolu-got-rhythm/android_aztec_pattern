package com.example.slime.experiment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Slime on 17/03/2017.
 */
public class AztecTest {
    private Aztec pattern;

    @Before
    public void setup() throws Exception{
        this.pattern = new Aztec(new Coordinates(5,5));
    }

    @Test
    public void testGetCurrentPattern() throws Exception {
        this.pattern.move();
        this.pattern.move();
        assertEquals(3, this.pattern.getCurrentPattern().size());
    }

    @Test
    public void testMultiple() throws Exception {
        this.pattern.move();
        this.pattern.move();
        this.pattern.move();
        this.pattern.move();
        assertEquals(9, this.pattern.getCurrentPattern().size());
    }

    @Test
    public void testCoordinates() throws Exception{
        assertEquals(1, this.pattern.getCurrentPattern().size());
        this.pattern.move();
//        int x = this.pattern.getCurrentPattern().get(1).getX();
//        int y = this.pattern.getCurrentPattern().get(1).getY();

        //assertEquals(12, x + y);

    }
}