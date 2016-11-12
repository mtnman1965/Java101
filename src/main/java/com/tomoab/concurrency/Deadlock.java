package com.tomoab.concurrency;

class Deadlock {

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    void a() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I'm in a()");
            b();
        }
    }

    void b() {
        synchronized (key2) {
            System.out.println("[" + Thread.currentThread().getName() + "] I'm in b()");
            c();
        }
    }

    private void c() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I'm in c()");
        }
    }
}
