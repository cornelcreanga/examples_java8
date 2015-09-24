package com.ccreanga.example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Supplier;

//http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
public class LambdaExampleMethodRef {

    public static void main(String[] args) {

        Person[] persons = PersonsRepo.persons();

        //Lambda expressions
        Comparator<Person> ageComparatorNew = (a, b) -> a.getBirthday().compareTo(b.getBirthday());

        //Lambda expressions - METHOD references

        Arrays.sort(persons,
                Person::compareByAge
        );

        //OR lambda expressions - predicates + method reference
        Arrays.sort(persons,
                Comparator.comparing(Person::getAge)
        );

        //Reference to a static method
        Comparator<Person> comparator = Person::compareByAge;
        //Reference to an instance method of a particular object
        comparator = ageComparatorNew::compare;
        //Reference to an instance method of an arbitrary object of a particular type

        String[] stringArray = { "Barbara", "James", "Mary", "John","Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray,(a,b)->a.compareTo(b));
        //will be replaced with
        Arrays.sort(stringArray, String::compareTo);
        //Reference to a constructor

        Supplier supplier = () -> { return new HashSet<>();};
        //will be replaced with
        supplier = HashSet::new;




    }

}
