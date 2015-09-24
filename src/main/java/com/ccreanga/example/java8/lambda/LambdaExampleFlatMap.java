package com.ccreanga.example.java8.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LambdaExampleFlatMap {


    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();


        //FLATMAP - Replaces each element of this stream with the contents of a mapped stream produced by applying the provided mapping function
        List<String> addresses = Arrays.stream(persons).map(Person::getAddresses).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(addresses);

        System.out.println("-------------------------------------------------------------------");

        Set<String> uniqueAddresses = Arrays.stream(persons).map(Person::getAddresses).flatMap(Collection::stream).collect(Collectors.toSet());
        System.out.println(uniqueAddresses);

    }

}
