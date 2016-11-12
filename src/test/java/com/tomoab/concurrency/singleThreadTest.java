package com.tomoab.concurrency;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * singleThreadTest
 */
public class singleThreadTest {
    @Test
    public void singleThreadTestMain() throws Exception {
        // run a single thread that simply announces itself
        // create lambda expression (java 8)
        // and use the Runnable pattern / class
        Runnable runnable = () -> System.out.println("I am running in " + Thread.currentThread().getName());
        Thread t = new Thread(runnable);
        t.start();

        // a single thread that calcs up to 1000
        LongWrapper lw = new LongWrapper(0L);
        Runnable incValueSingleThread = () -> {
            for (int i = 0; i < 1000; i++) {
                lw.incValue(false);
            }
        };
        t = new Thread(incValueSingleThread);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("value = " + lw.getValue() + " (should be 1,000)");
        assertEquals(lw.getValue(), 1000);
    }
}