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

        // new LexusRX
        Product lexusRX = new Product("Lexus RX", 43020, 3500);
        assertEquals(lexusRX.getName(), "Lexus RX");
        assertEquals(lexusRX.getWeight(), 3500);
        assertEquals(lexusRX.getCost(), 43020);

        // new LexusRX
        Product lexusIS = new Product("Lexus IS", 37825, 3583);
        assertEquals(lexusIS.getName(), "Lexus IS");
        assertEquals(lexusIS.getWeight(), 3583);
        assertEquals(lexusIS.getCost(), 37825);
    }
}
