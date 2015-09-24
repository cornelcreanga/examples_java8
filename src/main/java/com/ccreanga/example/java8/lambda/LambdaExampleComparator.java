package com.ccreanga.example.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExampleComparator {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(PersonsRepo.persons());

        Collections.sort(persons, (x, y) -> x.getName().compareTo(y.getName()));
        System.out.println(persons);
        System.out.println("-------------------------------------------------------------------");

        Collections.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println(persons);


    }

}
