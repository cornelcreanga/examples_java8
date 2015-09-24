package com.ccreanga.example.java8.lambda;

public class CheckPersonEligibleForArmyService implements CheckPerson {
    public boolean test(Person p) {
        return p.getAge() >= 18 && p.getAge() <= 50 && p.isMale();
    }
}