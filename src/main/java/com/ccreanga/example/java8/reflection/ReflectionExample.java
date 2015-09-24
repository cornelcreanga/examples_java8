package com.ccreanga.example.java8.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {

    //it only works when using javac with -parameters
    public static void main(String[] args) {
        Class<String> clz = String.class;
        for (Method m : clz.getDeclaredMethods()) {
            System.out.println(m.getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("  " + p.getName());
            }
        }
    }

}
