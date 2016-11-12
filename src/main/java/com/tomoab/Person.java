package com.tomoab;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        return period.getYears();
    }

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
