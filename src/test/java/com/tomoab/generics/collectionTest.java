package com.tomoab.generics;

import com.tomoab.Product;
import org.junit.Test;

import java.util.*;

/**
 * collectionTest
 */
public class collectionTest {
    private Product honda = new Product("Honda", 34000, 1800);
    private Product acura = new Product("Acura", 49000, 2200);
    private Product toyota = new Product("Toyota", 34500, 1500);
    private Product lexus = new Product("Lexus", 54500, 2500);
    private Product ford = new Product("Ford", 34000, 1800);
    private Product subaru = new Product("Subaru", 32000, 1800);
    private Product fiat = new Product("Fiat", 36000, 1800);

    @Test
    public void collectionTestMain() throws Exception {
        // explore methods on collections class
        // new list of product objects
        Collection<Product> products = new ArrayList<>();
        products.add(acura);
        products.add(toyota);
        products.add(fiat);
        System.out.println(products);

        // addAll method to add all at once
        Collection<Product> products2 = new ArrayList<>();
        Collections.addAll(products2, subaru, ford);
//        products2.add(subarau);
//        products2.add(ford);
        System.out.println(products2);

        // add all of second collection to first
        System.out.println("adding products2 to products");
        products2.addAll(products);
        System.out.println(products2);

        // contains all
        System.out.println("testing containsAll");
        if (products2.containsAll(products)) {
            System.out.println("products 2 contains all of products and had " + products2.size() + " elements");
        }
        System.out.println(products2);

        // remove all
        System.out.println("removing products");
        products2.removeAll(products);
        System.out.println(products2);

        // contains
        System.out.println("testing contains");
        if (products2.contains(subaru)) {
            System.out.println("products 2 contains subaru");
        }

        // iterate through products using iterator and print each
        System.out.println("printing out products one at a time using iterator");
        for (Product next : products) {
            System.out.println(next);
        }

        // iterate through products using for and print each
        System.out.println("printing out products one at a time using for");
        for (Product product : products2) {
            System.out.println(product);
        }

        // try to add an item when iterating using for loop
        System.out.println("adding item when iterating");
        try {
            for (Product product : products2) {
                System.out.println(product);
                if (product.getName() == "Subaru") {
                    // can't add items when using for - use iterator instead
                    products2.add(ford);
                }
            }
        } catch (Exception e) {
            System.out.println("caught exception - " + e.getMessage());
        }

        // clear products and print
        System.out.println("clearing products");
        products.clear();
        System.out.println("products = " + products);    }
}