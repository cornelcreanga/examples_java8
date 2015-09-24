package com.ccreanga.example.java8;

import java.util.function.Predicate;

public class LambdaExample2 {

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
                (Person p) -> p.getAge()>=18
        );
    }

}
