package com.ccreanga.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LambdaExample4 {


    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        System.out.println("-------------------------------------------------------------------");
        Arrays.stream(persons)
                .filter(
                        p -> p.getAge() >= 18)
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));

        //compute total age
        System.out.println("-------------------------------------------------------------------");
        Double averageAge = Arrays.stream(persons)
                .mapToInt((Person p) -> p.getAge())
                .average()
                .getAsDouble();
        System.out.println(averageAge);

        //OR
        System.out.println("-------------------------------------------------------------------");
        averageAge =  Arrays.stream(persons)
                        .mapToDouble((Person p) -> p.getAge())
                        .reduce( 0,
                                (acc,age)->acc+age
                        )/persons.length;
        System.out.println(averageAge);

        //REDUCE
        //it applies a binary operator to each element in the stream where
        //the first argument to the operator is the return value of the previous application
        //and the second argument is the current stream element.
        System.out.println("-------------------------------------------------------------------");
        Double harmonicMeanAge = persons.length/
                Arrays.stream(persons)
                .mapToDouble((Person p) -> p.getAge())
                .reduce( 0,
                        (acc,age)->acc+1/age
                );
        System.out.println(harmonicMeanAge);

        System.out.println("-------------------------------------------------------------------");
        //COLLECT  -  an aggregation operation where a "collection" is created and each element is "added" to that collection
        //Built in Collectors for most of the cases
        List<Person> filtered = Arrays.stream(persons).filter(p -> p.getAge() >= 18).collect(Collectors.toList());
        System.out.println(filtered);

        System.out.println("-------------------------------------------------------------------");
        //FLATMAP
        List<String> addresses = Arrays.stream(persons).map(d -> d.getAddresses()).flatMap(a -> a.stream()).collect(Collectors.toList());
        System.out.println(addresses);
        Set<String> uniqueAddresses = Arrays.stream(persons).map(d -> d.getAddresses()).flatMap(a->a.stream()).collect(Collectors.toSet());
        System.out.println(uniqueAddresses);

    }
}
