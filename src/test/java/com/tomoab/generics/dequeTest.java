package com.tomoab.generics;

import com.tomoab.Person;
import com.tomoab.Product;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * dequeTest
 */
public class dequeTest {
    @Test
    public void dequeTestMain() throws Exception {
        Product honda = new Product("Honda", 34000, 1800);
        Product acura = new Product("Acura", 49000, 2200);
        Product toyota = new Product("Toyota", 34500, 1500);
        Product fiat = new Product("Fiat", 36000, 1800);

        // define priority queue using comparator
        ArrayDeque<Product> products = new ArrayDeque<Product>();
        products.offer(acura);
        products.offer(honda);
        products.offer(toyota);
        products.offer(fiat);

        System.out.println("ArrayDeque elements");
        products.forEach(p -> System.out.println(p.getName()));

        System.out.println("removing elements, front then back");
        System.out.println(products.pollFirst());
        System.out.println(products.pollLast());
        System.out.println(products.pollFirst());
        System.out.println(products.pollLast());

        System.out.println("push and pop elements");
        products.push(toyota);
        products.push(acura);
        products.push(fiat);
        products.forEach(p -> System.out.println(p.getName()));
        while (products.size() > 0) {
            System.out.println(products.pop());
        }
    }
}