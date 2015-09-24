package com.ccreanga.example.java8;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExampleProdConsumer {

    public static void processPersonsWithPredicate(Person[] persons, Predicate<Person> predicate,Consumer<Person> consumer) {
        for (Person p : persons) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        processPersonsWithPredicate(
                persons,
                (Person p) -> p.getAge() >= 18,
                System.out::println
        );
        //OR
        System.out.println("-------------------------------------------------------------------");
        Arrays.stream(persons).limit(3)
                .filter(
                        p -> p.getAge() >= 18)
                                .map(Person::getName)
                                .forEach(System.out::println);


    }

}
