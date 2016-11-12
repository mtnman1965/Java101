package com.tomoab.generics;

import com.tomoab.Person;
import com.tomoab.Product;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

/**
 * navigableMapTest
 */
public class navigableMapTest {
    @Test
    public void navigableMapTestMain() throws Exception {
        Product honda = new Product("Honda", 34000, 1800);
        Product acura = new Product("Acura", 49000, 2200);
        Product toyota = new Product("Toyota", 34500, 1500);
        Product lexus = new Product("Lexus", 54500, 2500);
        Product ford = new Product("Ford", 34000, 1800);
        Product subaru = new Product("Subaru", 32000, 1800);
        Product fiat = new Product("Fiat", 36000, 1800);

        NavigableMap<String, Product> stringProductNavigableMap = new TreeMap<>();
        stringProductNavigableMap.put("acura", acura);
        stringProductNavigableMap.put("honda", honda);
        stringProductNavigableMap.put("toyota", toyota);
        stringProductNavigableMap.put("fiat", fiat);
        System.out.println(stringProductNavigableMap);

        System.out.println("first entry = " + stringProductNavigableMap.firstEntry());
        System.out.println("last entry = " + stringProductNavigableMap.lastEntry());
        System.out.println("first key = " + stringProductNavigableMap.firstKey());
        System.out.println("last key = " + stringProductNavigableMap.lastKey());

        System.out.println("ascending key order");
        Set keySet = stringProductNavigableMap.keySet();
        keySet.forEach(s -> System.out.println(s + " -> " + stringProductNavigableMap.get(s)));
        System.out.println("descending key order");
        keySet = stringProductNavigableMap.descendingKeySet();
        keySet.forEach(s -> System.out.println(s + " -> " + stringProductNavigableMap.get(s)));

        // get key/value pair for greatest entry <= key/value
        System.out.println("floor entry for 'h' = " + stringProductNavigableMap.floorEntry("h"));
        System.out.println("floor key for 'h' = " + stringProductNavigableMap.floorKey("h"));

        // get key/value pair for least entry >= key
        System.out.println("ceiling entry for 'h' = " + stringProductNavigableMap.ceilingEntry("h"));
        System.out.println("ceiling key for 'h' = " + stringProductNavigableMap.ceilingKey("h"));

        // Java8 enhancements
        System.out.println("removing acura");
        stringProductNavigableMap.remove("acura");
        keySet = stringProductNavigableMap.keySet();
        keySet.forEach(s -> System.out.println(s + " -> " + stringProductNavigableMap.get(s)));

        System.out.println("replace honda");
        Product chrysler = new Product("chrysler", 25000, 4000);
        stringProductNavigableMap.replace("honda", chrysler);
        keySet = stringProductNavigableMap.keySet();
        keySet.forEach(s -> System.out.println(s + " -> " + stringProductNavigableMap.get(s)));
        stringProductNavigableMap.remove("honda");

        System.out.println("putIfAbsent of chrysler");
        stringProductNavigableMap.put("honda", honda);
        stringProductNavigableMap.putIfAbsent("chrysler", chrysler);

        System.out.println("computeIfAbsent for bmw");
        stringProductNavigableMap.computeIfAbsent("bmw", (name) -> new Product(name, 60000, 3500));
        keySet = stringProductNavigableMap.keySet();
        keySet.forEach(s -> System.out.println(s + " -> " + stringProductNavigableMap.get(s)));    }
}