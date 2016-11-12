package com.tomoab.concurrency;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * deadlockTest
 */
public class deadlockTest {
    @Test
    @Ignore
    public void deadlockTestMain() throws Exception {
        Deadlock dl = new Deadlock();
        Runnable r1 = () -> dl.a();
        Runnable r2 = () -> dl.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("existing doThreadDeadlock");
    }
}