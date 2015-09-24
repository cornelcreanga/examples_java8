package com.ccreanga.example.java8.lambda;

import java.util.Arrays;

public class LambdaExampleReduce {


    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        //compute total age
        System.out.println("-------------------------------------------------------------------");
        Double averageAge = Arrays.stream(persons)
                .mapToInt(Person::getAge)
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



    }
}
