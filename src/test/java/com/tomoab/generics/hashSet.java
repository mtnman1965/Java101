package com.tomoab.generics;

import com.tomoab.Product;
import org.junit.Test;

import java.util.*;

/**
 * hashSet
 */
public class hashSet {
    private Product honda = new Product("Honda", 34000, 1800);
    private Product acura = new Product("Acura", 49000, 2200);
    private Product toyota = new Product("Toyota", 34500, 1500);
    private Product lexus = new Product("Lexus", 54500, 2500);
    private Product ford = new Product("Ford", 34000, 1800);
    private Product subaru = new Product("Subaru", 32000, 1800);
    private Product fiat = new Product("Fiat", 36000, 1800);

    @Test
    public void hashSetTest() throws Exception {
        // there are no guarantees on hashset order, but uniqueness is maintained
        // based on HashMap - can override = and object.hashCode()

        // add items to a hash set
        HashSet<Product> products = new HashSet<Product>();
        products.add(acura);
        products.add(toyota);
        products.add(lexus);
        products.add(honda);
        System.out.println(products);

        if (!products.add(honda)) {
            System.out.println("trying to add another honda returns false as expected");
        }

        // try to add another honda with the same details - requires overriding =
        // because otherwise it's an object reference comparison
        Product honda2 = new Product("Honda", 34000, 1800);
        if (!products.add(honda2)) {
            System.out.println("trying to add another honda (new obj) returns false as expected");
        }

        // print using foreach
        System.out.println("printing each element using foreach() and lambda");
        products.forEach(p -> System.out.println(p.getName()));

        // try removeIf with lambda expression
        if (products.removeIf(p -> p.getName() == "Lexus")) {
            System.out.println("Lexus removed");
        }

        // iterate through HashSet
        for (Product p : products) {
            System.out.println(p);
        }
    }
}