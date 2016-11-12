package com.tomoab.java8;

import com.tomoab.Person;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * java8StreamsTest
 */
public class java8StreamsTest {
    @Test
    public void java8StreamsTestMain() throws Exception {
        // open up file of people with birth dates
        List<Person> persons = new ArrayList<>();
        try (
                // BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("people.txt")));
                BufferedReader reader = Files.newBufferedReader(Paths.get("people.txt"));
                Stream<String> stream = reader.lines();
        ) {
            // use intermediate map() to parse lines of file
            stream.map(
                    // lambda expression to parse line and add to persons list
                    line -> {
                        // parse the line
                        String[] s = line.split(" ");
                        String name = s[0].trim();
                        int year = Integer.parseInt(s[1]);
                        Month month = Month.of(Integer.parseInt(s[2]));
                        int day = Integer.parseInt(s[3]);

                        // add to persons list
                        Person p = new Person(name, LocalDate.of(year, month, day));
                        persons.add(p);

                        return p;
                    }
            )
                    // print out each person object using terminal forEach() on stream
                    .forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println(ex);
        }

        assertEquals(persons.size(), 4);

        // use stream on persons list to print ages
        System.out.println("use stream to print out ages");
        persons.stream().forEach(
                p -> {
                    System.out.println(p.getName() + " is " + p.getAge() + " years old");
                }
        );

        // do same using foreach loop
        System.out.println("use foreach to print out ages");
        for (Person p : persons) {
            System.out.println(p.getName() + " is " + p.getAge() + " years old");
        }
    }
}