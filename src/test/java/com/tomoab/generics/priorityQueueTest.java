package com.tomoab.generics;

import com.tomoab.Product;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * priorityQueue
 */
public class priorityQueueTest {
    @Test
    public void priorityQueueTestMain() throws Exception {
        Product honda = new Product("Honda", 34000, 1800);
        Product acura = new Product("Acura", 49000, 2200);
        Product toyota = new Product("Toyota", 34500, 1500);
        Product fiat = new Product("Fiat", 36000, 1800);

        // define priority queue using comparator
        PriorityQueue<Product> products = new PriorityQueue<>(Product.BY_COST);
        products.offer(acura);
        products.add(honda);
        products.add(toyota);
        products.add(fiat);

        System.out.println("priority queue elements");
        products.forEach(p -> System.out.println(p));

        System.out.println("removing elements, cheapest to most expensive");
        while (products.size() > 0) {
            System.out.println(products.remove());
        }
    }
}