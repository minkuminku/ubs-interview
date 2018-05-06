package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mayankgupta on 06/05/18.
 */

public class BerlinClockTest {


    @Test
    public void testTimeConversion(){

        BerlinClock berlinClock = new BerlinClock();

        Assert.assertEquals("Y\n" +
                "ROOO\n" +
                "OOOO\n" +
                "YYRYYRYYRYY\n" +
                "YOOO",berlinClock.convertTime("5:56:00"));

        Assert.assertEquals("Y\n" +
                "RRRO\n" +
                "OOOO\n" +
                "OOOOOOOOOOO\n" +
                "YYYY",berlinClock.convertTime("15:4:00"));


    }


}
