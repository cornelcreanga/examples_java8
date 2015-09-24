package com.ccreanga.example.java8.lambda;

import java.time.LocalDate;
import java.util.Arrays;

public class PersonsRepo {

    public static Person[] persons(){
        return new Person[]{
                new Person("nero",LocalDate.of(1956,1,1), Person.Gender.MALE, Arrays.asList("Roma", "Delphi")),
                new Person("traian",LocalDate.of(1955,1,1), Person.Gender.MALE, Arrays.asList("Delphi")),
                new Person("agripina",LocalDate.of(1990,1,1), Person.Gender.FEMALE, Arrays.asList("Athena","Roma", "Delphi")),
                new Person("agripina",LocalDate.of(1977,1,1), Person.Gender.FEMALE, Arrays.asList("Roma")),
                new Person("hadrian",LocalDate.of(1959,1,1), Person.Gender.MALE, Arrays.asList("Roma")),
                new Person("brutus",LocalDate.of(2000,1,1), Person.Gender.MALE, Arrays.asList("Pompei")),
        };

    }
}
