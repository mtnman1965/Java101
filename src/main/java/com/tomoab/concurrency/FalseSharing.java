package com.tomoab.concurrency;

/*
    This class demonstrates performance issues related to data alignment in modern CPU caches.
    By padding a long var that is changing frequently you can eliminate cache invalidations which
    require another fetch from RAM.  This is also known as "false sharing" and has "visibility."
    See Concurency Threading note.
 */

class FalseSharing {

    private static int NUM_THREADS_MAX = 4;
    private final static long ITERATIONS = 50_000_000L;

    // define class with padded data around value
    private final static class VolatileLongPadded {
        public long q1, q2, q3, q4, q5, q6;
        // note use of volatile
        volatile long value = 0L;
        public long q8, q9, q10, q11, q12, q13;
    }

    // and another with no padding
    private final static class VolatileLongUnPadded {
        // note use of volatile
        volatile long value = 0L;
    }

    // define arrays of those classes and fill them
    private static VolatileLongPadded[] paddedLongs;
    private static VolatileLongUnPadded[] unPaddedLongs;
    static {
        paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLongs.length; i++) {
            paddedLongs[i] = new VolatileLongPadded();
        }
        unPaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX];
        for (int i =0; i < unPaddedLongs.length; i++) {
            unPaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    private static Runnable createPaddedRunnable (final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (--i > 0) {
                paddedLongs[k].value = i;
            }
        };
    }

    private static Runnable createUnPaddedRunnable (final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (--i > 0) {
                unPaddedLongs[k].value = i;
            }
        };
    }

    static void run() {

        // show for increasing number of threads
        try {
            long startTime, endTime;
            for (int i = 1; i <= NUM_THREADS_MAX; i++) {

                Thread[] threads = new Thread[i];

                for (int j = 0; j < threads.length; j++) {
                    threads[j] = new Thread(createPaddedRunnable(j));
                }

                startTime = System.currentTimeMillis();
                for (Thread t: threads) { t.start(); }
                for (Thread t: threads) { t.join(); }
                endTime = System.currentTimeMillis();
                System.out.printf("  Padded %d threads = %d ms%n", i, endTime - startTime);

                for (int j = 0; j < threads.length; j++) {
                    threads[j] = new Thread(createUnPaddedRunnable(j));
                }

                startTime = System.currentTimeMillis();
                for (Thread t: threads) { t.start(); }
                for (Thread t: threads) { t.join(); }
                endTime = System.currentTimeMillis();
                System.out.printf("UnPadded %d threads = %d ms%n", i, endTime - startTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
