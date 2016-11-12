package com.tomoab.generics;

import com.tomoab.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * arrayList
 */
public class arrayList {

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