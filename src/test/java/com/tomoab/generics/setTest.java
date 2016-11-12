package com.tomoab.generics;

import com.tomoab.Product;
import org.junit.Test;

import java.util.*;

/**
 * setTest
 */
public class setTest {
    private Product honda = new Product("Honda", 34000, 1800);
    private Product acura = new Product("Acura", 49000, 2200);
    private Product toyota = new Product("Toyota", 34500, 1500);
    private Product lexus = new Product("Lexus", 54500, 2500);
    private Product ford = new Product("Ford", 34000, 1800);
    private Product subaru = new Product("Subaru", 32000, 1800);
    private Product fiat = new Product("Fiat", 36000, 1800);

    @Test
    public void setSortingTestMain() throws Exception {
        // create a list, and add all products
        List<Product> products = new ArrayList<Product>();
        Collections.addAll(products, honda, acura, toyota, lexus, ford, subaru, fiat);

        System.out.println("sorting and printing by cost");
        products.sort(Product.BY_COST);
        products.forEach(p -> System.out.println(p.getName()));

        System.out.println("sorting and printing by name");
        products.sort(Product.BY_NAME);
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void sortedSetTestMain() throws Exception {
        // add to sorted set
        // default compareTo is by name - should be sorted by name
        // TODO: change Product.compareTo() to be by cost
        SortedSet<Product> products = new TreeSet<>();
        Collections.addAll(products, honda, acura, toyota, lexus, ford, subaru, fiat);
        System.out.println("products (should be in name order)");
        products.forEach(p -> System.out.println(p.getName()));

        // get various subsets and print out
        System.out.println("product subset to lexus");
        SortedSet<Product> productsSubSet = products.headSet(lexus);
        productsSubSet.forEach(p -> System.out.println(p.getName()));

        System.out.println("product subset from lexus");
        productsSubSet = products.tailSet(lexus);
        productsSubSet.forEach(p -> System.out.println(p.getName()));

        System.out.println("product subset");
        productsSubSet = products.subSet(acura, subaru);
        productsSubSet.forEach(p -> System.out.println(p.getName()));
    }
}