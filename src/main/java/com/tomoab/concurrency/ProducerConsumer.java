package com.tomoab.concurrency;

/*
* A simple example of the producer / consumer pattern with both non-thread safe and synchronized thread safe methods.
* */

class ProducerConsumer {
    private int[] buffer = new int[10];
    private int count = 0;
    private final Object lock = new Object();

    private class Producer {
        void produce(boolean sync) {
            if (sync) {
                synchronized (lock) {
                    if (isFull(buffer)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // add an item
                    buffer[count++] = 1;
                    lock.notify();
                }
            } else {
                // if buffer at capacity, just loop (bad coding)
                while (isFull(buffer)) {
                }
                // otherwise add an item
                buffer[count++] = 1;
            }
        }
    }

    private class Consumer {
        void consume(boolean sync) {
            if (sync) {
                synchronized (lock) {
                    if (isEmpty(buffer)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // remove an item
                    buffer[--count] = 0;
                    lock.notify();
                }
            } else {
                // if buffer is empty, just loop (bad coding)
                while (isEmpty(buffer)) {
                }
                // otherwise get an item
                buffer[--count] = 0;
            }
        }
    }

    private boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    private boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    void doProduceConsume(boolean sync) {
        final int NUM_PRODUCE = 50;
        final int NUM_CONSUME = 45;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        // create Runnable object that produces things
        Runnable produceTask = () -> {
            for (int i = 0; i < NUM_PRODUCE; i++) {
                producer.produce(sync);
            }
            System.out.println("done producing");
        };

        // create Runnable object that consumes things
        Runnable consumeTask = () -> {
            for (int i = 0; i < NUM_CONSUME; i++) {
                consumer.consume(sync);
            }
            System.out.println("done consuming");
        };

        // create thread objects with specified tasks to run
        Thread consumerThread = new Thread(consumeTask);
        Thread producerThread = new Thread(produceTask);

        // start the threads
        consumerThread.start();
        producerThread.start();

        // and wait for them to complete
        try {
            consumerThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int shouldRemain = NUM_PRODUCE - NUM_CONSUME;
        if (sync) {
            System.out.printf("data in the buffer: (should be %d) %d%n", shouldRemain, count);
        } else {
            System.out.printf("data in the buffer: (should be %d, but probably won't b/c not thread safe) %d%n",
                    shouldRemain, count);
        }

    }
}
