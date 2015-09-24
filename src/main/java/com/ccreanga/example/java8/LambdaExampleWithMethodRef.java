package com.ccreanga.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Supplier;

//http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html
public class LambdaExampleWithMethodRef {

    public static void main(String[] args) {

        Person[] persons = PersonsRepo.persons();

        Comparator<Person> ageComparator = new Comparator<Person>() {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        };
        Arrays.sort(persons, ageComparator);

        //Lambda expressions
        Comparator<Person> ageComparatorNew = (Person a, Person b) -> a.getBirthday().compareTo(b.getBirthday());
        //or
        Arrays.sort(persons,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        //Lambda expressions
        Arrays.sort(persons,
                (Person a, Person b) -> {
                    return Person.compareByAge(a, b);
                }
        );

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
        comparator = ageComparator::compare;
        //Reference to an instance method of an arbitrary object of a particular type

        String[] stringArray = { "Barbara", "James", "Mary", "John","Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray,(a,b)->a.compareTo(b));
        //replaced with
        Arrays.sort(stringArray, String::compareTo);
        //Reference to a constructor

        Supplier supplier = () -> { return new HashSet<>();};
        //replaced with
        supplier = HashSet::new;




    }

}
