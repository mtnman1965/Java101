package com.tomoab.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * multipleThreadSyncTest
 */
public class multipleThreadSyncTest {
    @Test
    public void multipleThreadSyncMain() throws Exception {
        // 1000 threads WITH synchronization, which should add to 1,000,000
        LongWrapper lws = new LongWrapper(0L);
        Runnable incValueSingleThreadSynced = () -> {
            for (int i = 0; i < 1000; i++) {
                lws.incValue(true);
            }
        };

        Thread[] threadsSynced = new Thread[1000];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadsSynced.length; i++) {
            threadsSynced[i] = new Thread(incValueSingleThreadSynced);
            threadsSynced[i].start();
        }
        for (Thread aThreadsSynced : threadsSynced) {
            try {
                aThreadsSynced.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        assertEquals(lws.getValue(), 1000000);
        System.out.println("value = " + lws.getValue() + " (should be 1,000,000 because sync)");
        System.out.println("time to complete = " + (endTime - startTime) + " ms");
    }
}