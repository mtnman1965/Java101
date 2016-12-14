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
        Product chevy = new Product("Chevy", 25000, 1950);
        assertEquals(chevy.getName(), "Chevy");
        assertEquals(chevy.getWeight(), 1950);
        assertEquals(chevy.getCost(), 25000);

        // new Porche
        Product porsche = new Product("Porsche 911", 89400, 3150);
        assertEquals(porsche.getName(), "Porsche 911");
        assertEquals(porsche.getWeight(), 3150);
        assertEquals(porsche.getCost(), 89400);

        // new Lexus
        Product lexus = new Product("Lexus RX", 43020, 3500);
        assertEquals(lexus.getName(), "Lexus RX");
        assertEquals(lexus.getWeight(), 3500);
        assertEquals(lexus.getCost(), 43020);

    }
}
