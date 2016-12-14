package com.tomoab.generics;

import com.tomoab.Product;
import com.tomoab.Shipment;
import org.junit.Test;

import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * arrayList
 */
public class arrayList {

    private Product honda = new Product("Honda", 34000, 1800);
    private Product acura = new Product("Acura", 49000, 2200);
    private Product toyota = new Product("Toyota", 34500, 1500);
    private Product lexus = new Product("Lexus", 54500, 2500);
    private Product ford = new Product("Ford", 34000, 1800);
    private Product subaru = new Product("Subaru", 32000, 1800);
    private Product fiat = new Product("Fiat", 36000, 1800);

    @Test
    public void doShipment() throws Exception {
        // create shipment object
        Shipment shipment = new Shipment();
        shipment.add(acura);
        shipment.add(toyota);
        shipment.add(lexus);
        shipment.add(honda);

        // iterate through
        List<Product> productsToShip = shipment.getProducts();
        for (Product product : productsToShip) {
            System.out.println("shipping " + product.getName());
        }

        // prepare shipment
        shipment.prepare();
        System.out.println("cheap products");
        System.out.println(shipment.getCheapProducts());
        System.out.println("expensive products");
        System.out.println(shipment.getExpensiveProducts());
    }

    @Test
    public void doArrayList() throws Exception {
        // lists are collections with iteration order
        // they have an index
        ArrayList<Product> products = new ArrayList<>();
        Collections.addAll(products, acura, toyota, ford, subaru, fiat);
        System.out.println(products);
        assert (products.contains(acura));
        assert (products.contains(toyota));
        assert (products.contains(ford));
        assert (products.contains(subaru));
        assert (products.contains(fiat));
        assert (!products.contains(honda));
    }

    @Test
    public void arrayListTest() throws Exception {

        // linked lists are better for adds/removes than array lists
        // array lists are better for lookups

        int MAX_ITEMS = 30000;

        // create large array list
        ArrayList<String> arrayList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            String s = randomAlphabetic(30);
            arrayList.add(s);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("adding to ArrayList = " + (endTime - startTime) + " ms");

        // do lookups
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            String s = arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("getting from ArrayList = " + (endTime - startTime) + " ms");

        // remove 1st element until completely done
        startTime = System.currentTimeMillis();
        while (arrayList.size() > 0) {
            arrayList.remove(0);
        }
        endTime = System.currentTimeMillis();
        System.out.println("removing all from ArrayList = " + (endTime - startTime) + " ms");

        LinkedList<String> linkedList = new LinkedList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            String s = randomAlphabetic(30);
            linkedList.add(s);
        }
        endTime = System.currentTimeMillis();
        System.out.println("adding to LinkedList = " + (endTime - startTime) + " ms");

        // do lookups - should be much slower than gets from ArrayList
        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITEMS; i++) {
            String s = linkedList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("getting from LinkedList = " + (endTime - startTime) + " ms");

        // remove 1st element until completely done - should be faster than removals from ArrayList
        startTime = System.currentTimeMillis();
        while (linkedList.size() > 0) {
            linkedList.remove(0);
        }
        endTime = System.currentTimeMillis();
        System.out.println("removing all from LinkedList = " + (endTime - startTime) + " ms");
    }
}