package com.tomoab.concurrency;

/**
 * Simple Singleton pattern as defined in GoF.  This isn't thread safe as described below.
 * See Concurrent Threading note.
 */
class Singleton {

    private static Singleton instance;

    // private prevents outsiders from instantiating with new()
    // they need to use getInstance()
    private Singleton() {}

    static Singleton getInstance() {

        // this code presents problems on multi-core multi-threaded systems.
        // the instance == null is a read operation
        if (instance == null) {
            // and instance = new singleton() is a write operation
            // having these execute in two different threads can cause race conditions
            // there is no "happens before link" between them
            System.out.println("instance is null - creating new one");
            instance = new Singleton();
        }
        System.out.println("returning instance");
        return instance;
    }

    static void doSomething() {
        System.out.println("doSomething says hi");
    }
}
