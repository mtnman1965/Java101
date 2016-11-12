package com.tomoab.java8;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

/**
 * java8DatesTest
 */
public class java8DatesTest {
    @Test
    public void java8DatesTestMain() throws Exception {
        /*
        java 8 dates
        use the Instant and Duration objects
        Instant 0 is 1/1/1970 at midnight
        min is 1 billion years ago, and max is year 1 billion
        */
        System.out.println("min = " + Instant.MIN);
        System.out.println("max = " + Instant.MAX);
        System.out.println("now = " + Instant.now());
        Instant start = Instant.now();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Duration elapsed = Duration.between(start, Instant.now());
        System.out.println("duration of sleep of 200 ms = " + elapsed.toMillis() + " ms");

        // use the LocalDate and Period objects (between LocalDates)
        LocalDate dateOfBirth = LocalDate.of(1965, Month.FEBRUARY, 6);
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        System.out.println("years since my birth = " + period.getYears());
        System.out.println("born on a " + dateOfBirth.getDayOfWeek());
        assertEquals(dateOfBirth.getDayOfWeek().toString(), "SATURDAY");

        // do some date deltas using temporal adjusters
        System.out.println("next Friday is " + now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("previous Friday was " + now.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
        System.out.println("first day of next month is " + now.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("XMAS this year is on a " + LocalDate.of(now.getYear(), 12, 25).getDayOfWeek());

        // time zones
        System.out.println("In London, it's currently " + ZonedDateTime.now(ZoneId.of("Europe/London")));
        System.out.println("In Sydney, it's currently " + ZonedDateTime.now(ZoneId.of("Australia/Sydney")));
    }
}