package com.tomoab.generics;

import com.tomoab.Person;
import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * hashMapTest
 */
public class hashMapTest {
    @Test
    public void hashMapTestMain() throws Exception {
        Person don = new Person("Don Draper", LocalDate.of(1925, 1, 1));
        Person peggy = new Person("Peggy Olson", LocalDate.of(1940, 1, 1));
        Person bert = new Person("Bert Cooper", LocalDate.of(1900, 1, 1));

        ArrayList<Person> madMen = new ArrayList<>();
        madMen.add(don);
        madMen.add(peggy);
        madMen.add(bert);
        System.out.println(madMen);

        HashMap<String, Person> stringPersonHashMap = new HashMap<>();
        stringPersonHashMap.put(don.getName(), don);
        stringPersonHashMap.put(peggy.getName(), peggy);
        stringPersonHashMap.put(bert.getName(), bert);
        System.out.println(stringPersonHashMap);

        // sort increasing age
        Collections.sort(madMen, new AgeComparator());
        System.out.println(madMen);

        // sort decreasing age
        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
        System.out.println(madMen);
    }
}