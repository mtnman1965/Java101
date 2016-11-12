package com.tomoab.concurrency;

/**
 * Thread safe Singleton.
 * See Concurrent Threading note.
 */
class SingletonThreadSafe {

    private static final Object lock = new Object();

    // note use of volatile
    private static volatile SingletonThreadSafe instance;

    // private prevents outsiders from instantiating with new()
    // they need to use getInstance()
    private SingletonThreadSafe() {}

    static SingletonThreadSafe getInstance() {

        // this code works on multi-core systems and is thread safe
        // the instance != null is a read operation
        if (instance != null) {
            System.out.println("returning instance");
            return instance;
        }

        synchronized (lock) {
            // and instance = new singleton() is a write operation
            // having these execute in two different threads can cause race conditions
            // so we sync them
            if (instance == null) {
                System.out.println("instance is null - creating new one");
                instance = new SingletonThreadSafe();
            }
            System.out.println("returning instance (synced)");
            return instance;
        }
    }

    static void doSomething() {
        System.out.println("doSomething says hi");
    }
}
