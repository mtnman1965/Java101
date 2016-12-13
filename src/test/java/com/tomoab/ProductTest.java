package com.tomoab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ProductTest
 */
public class ProductTest {
    @Test
    public void getName() throws Exception {
        Product honda = new Product("Honda", 34000, 1800);
        assertEquals(honda.getName(), "Honda");
        assertEquals(honda.getWeight(), 1800);
        assertEquals(honda.getCost(), 34000);

        // New Toyota
        Product toyota = new Product("Toyota", 29000, 1600);
        assertEquals(toyota.getName(), "Toyota");
        assertEquals(toyota.getWeight(), 1600);
        assertEquals(toyota.getCost(), 29000);

        // New Chevy
        // this is a heavy vehicle, but the price is right
        // price isn't that low!
        Product toyota = new Product("Chevy", 25000, 1900);
        assertEquals(toyota.getName(), "Chevy");
        assertEquals(toyota.getWeight(), 1900);
        assertEquals(toyota.getCost(), 25000);
    }
}
