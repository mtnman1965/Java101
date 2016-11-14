package com.tomoab;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 */
public class Misc {

    @Test
    public void doRegExp() {
        String s = "apple, apple and orange please";
        assertEquals(s.replaceAll("ple", "ricot"), "apricot, apricot and orange ricotase");
        assertEquals(s.replaceAll("ple\\b", "ricot"), "apricot, apricot and orange please");
    }

    @Test
    public void doFormatSpecifiers() {
        assertEquals(String.format("%#o", 32), "040");
        assertEquals(String.format("%#x", 32), "0x20");
        assertEquals(String.format("%#X", 32), "0X20");
        assertEquals(String.format("W:%d X:%d", 5, 233), "W:5 X:233");
        assertEquals(String.format("W:%4d X:%4d", 5, 233), "W:   5 X: 233");
        assertEquals(String.format("W:%05d X:%05d", 5, 233), "W:00005 X:00233");
        assertEquals(String.format("W:%04.2f X:%4.2f", 5.2323, 233.2342), "W:5.23 X:233.23");
    }

    @Test
    public void doStringJoins() {

        StringJoiner sj = new StringJoiner(",");
        sj.add("alpha").add("beta").add("gamma");
        assertEquals(sj.toString(), "alpha,beta,gamma");

        sj = new StringJoiner("], [", "[", "]");
        sj.add("alpha").add("beta").add("gamma");
        assertEquals(sj.toString(), "[alpha], [beta], [gamma]");

        sj = new StringJoiner(", ", "{", "}");
        sj.add("alpha").add("beta").add("gamma");
        assertEquals(sj.toString(), "{alpha, beta, gamma}");
    }

    @Test
    public void doLogging() {
        Logger logger = Logger.getLogger("");

        // note there's a logging.properties file in C:\Program Files\Java\jre1.8.0_102\lib to set
        System.out.println("Logging level is: " + logger.getLevel());
        logger.setLevel(Level.FINEST);
        logger.getHandlers()[0].setLevel(Level.FINEST);
        System.out.println("Logging level is now: " + logger.getLevel());

        // write out a few logging calls
        logger.log(Level.SEVERE, "severe log");
        logger.severe("severe log 2");
        logger.log(Level.INFO, "info log");
        logger.info("info log 2");
        logger.log(Level.FINE, "fine log");
        logger.fine("fine log 2");
        logger.log(Level.FINEST, "finest log");
        logger.finest("finest log 2");

        // parameterized messages
        logger.log(Level.SEVERE, "{0} is my favorite", "angel food cake");

        int p1 = 2;
        String p2 = "angel food cake";
        String message = "I'll take " + p1 +" of " + p2;
        logger.log(Level.SEVERE, message);
    }
}
