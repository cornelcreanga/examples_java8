package com.ccreanga.example.java8.lambda.methodref;

import com.ccreanga.example.java8.Person;
import com.ccreanga.example.java8.PersonsRepo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Supplier;

public class LambdaExampleMethodRef {

    public static void main(String[] args) {

        Person[] persons = PersonsRepo.persons();

        //Lambda expressions
        Comparator<Person> ageComparatorNew = (a, b) -> a.getBirthday().compareTo(b.getBirthday());


        //lambda expression
        Arrays.sort(persons,
                Comparator.comparing(p->p.getAge())
        );

        //OR lambda expression + method reference
        Arrays.sort(persons,
                Comparator.comparing(Person::getAge)
        );

        //it can also be a reference to a constructor

        Supplier supplier = () -> { return new HashSet<>();};
        //replaced with
        supplier = HashSet::new;




    }

}
