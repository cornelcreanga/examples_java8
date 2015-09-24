package com.ccreanga.example.java8;

public class LambdaExampleSyntax {

    public static void printPersons(Person[] persons, CheckPerson check) {
        for (Person p : persons) {
            if (check.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = PersonsRepo.persons();

        CheckPersonMajorityAge checkPersonMajorityAge = new CheckPersonMajorityAge();
        printPersons(persons,checkPersonMajorityAge);

        printPersons(persons, new CheckPerson() {
            public boolean test(Person p) {
                return p.getAge()>=18;
            }
        });

        printPersons(
                persons,
                (Person p) -> {return p.getAge()>=18;}
        );

        //condensed
        printPersons(
                persons,
                p -> p.getAge()>=18
        );

    }
}
