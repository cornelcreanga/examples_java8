package com.ccreanga.example.java8;


public class CheckPersonMajorityAge implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.getAge()>=18;
    }
}
