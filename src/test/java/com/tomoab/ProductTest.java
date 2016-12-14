package com.tomoab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ProductTest
 */
public class ProductTest {
    @Test
    public void getName() throws Exception {
        Product hondaCivic = new Product("Honda Civic", 18740, 2742);
        assertEquals(hondaCivic.getName(), "Honda Civic");
        assertEquals(hondaCivic.getWeight(), 2742);
        assertEquals(hondaCivic.getCost(), 18740);

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

        // new Tesla Model S
        Product teslaModelS = new Product("Tesla Model S", 68000, 4608);
        assertEquals(teslaModelS.getName(), "Tesla Model S");
        assertEquals(teslaModelS.getWeight(), 4608);
        assertEquals(teslaModelS.getCost(), 68000);

        // new Tesla Model X
        Product teslaModelX = new Product("Tesla Model X", 74000, 5271);
        assertEquals(teslaModelX.getName(), "Tesla Model X");
        assertEquals(teslaModelX.getWeight(), 5271);
        assertEquals(teslaModelX.getCost(), 74000);

        // new LexusRX
        Product lexusRX = new Product("Lexus RX", 43020, 3500);
        assertEquals(lexusRX.getName(), "Lexus RX");
        assertEquals(lexusRX.getWeight(), 3500);
        assertEquals(lexusRX.getCost(), 43020);

        // new LexusIS
        Product lexusIS = new Product("Lexus IS", 37825, 3583);
        assertEquals(lexusIS.getName(), "Lexus IS");
        assertEquals(lexusIS.getWeight(), 3583);
        assertEquals(lexusIS.getCost(), 37825);
    }
}
