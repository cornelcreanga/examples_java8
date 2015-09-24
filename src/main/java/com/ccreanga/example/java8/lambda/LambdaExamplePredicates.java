package com.ccreanga.example.java8.lambda;

import java.util.function.Predicate;

public class LambdaExamplePredicates {

    public static void printPersonsWithPredicate(Person[] persons, Predicate<Person> predicate) {
        for (Person p : persons) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        printPersonsWithPredicate(
                persons,
                p -> p.getAge()>=18
        );
    }

}
