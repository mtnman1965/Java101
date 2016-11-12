package com.tomoab.concurrency;

class LongWrapper {
    private long l;
    private final Object key = new Object();

    LongWrapper(long l) {
        this.l = l;
    }

    long getValue() {
        return l;
    }

    void incValue(boolean sync) {
        if (sync) {
            synchronized (key) {
                l = l + 1;
            }
        } else {
            l = l + 1;
        }
    }
}
