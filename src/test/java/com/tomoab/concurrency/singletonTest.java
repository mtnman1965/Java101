package com.tomoab.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * singletonTest
 */
public class singletonTest {
    @Test
    public void singletonTestMain() throws Exception {
        // demonstrate non-thread safe Singleton

        // note following isn't allowed because constructor is private
        //Singleton singletonNotAllowed = new Singleton();

        // get the Singleton properly
        Singleton singleton = Singleton.getInstance();
        assertNotNull(singleton);
        singleton.doSomething();

        // get the thread-safe singleton
        SingletonThreadSafe singletonThreadSafe = SingletonThreadSafe.getInstance();
        assertNotNull(singletonThreadSafe);
        singletonThreadSafe.doSomething();
    }
}