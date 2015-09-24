package com.ccreanga.example.java8.lambda;


public class CheckPersonMajorityAge implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.getAge()>=18;
    }
}
