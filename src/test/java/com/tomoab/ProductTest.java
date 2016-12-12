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

        Product toyota = new Product("Toyota", 29000, 1700);
        assertEquals(toyota.getName(), "Toyota");
        assertEquals(toyota.getWeight(), 1700);
        assertEquals(toyota.getCost(), 29000);
    }
}
