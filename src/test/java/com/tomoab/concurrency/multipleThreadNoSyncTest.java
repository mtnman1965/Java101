package com.tomoab.concurrency;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * multipleThreadNoSyncTest
 */
public class multipleThreadNoSyncTest {
    @Test
    @Ignore
    public void multipleThreadNoSyncMain() throws Exception {
        // 1000 threads w/o synchronization, which should not add to 1,000,000
        LongWrapper lw = new LongWrapper(0L);
        Runnable incValueSingleThread = () -> {
            for (int i = 0; i < 1000; i++) {
                lw.incValue(false);
            }
        };

        Thread[] threads = new Thread[1000];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(incValueSingleThread);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("value = " + lw.getValue() + " (should, but won't be 1,000,000 because no sync)");
        System.out.println("time to complete = " + (endTime - startTime) + " ms");
    }
}