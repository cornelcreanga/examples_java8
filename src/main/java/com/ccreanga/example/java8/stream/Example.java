package com.ccreanga.example.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {
        List<String> peoples = Arrays.asList("mihai","adina","emil");
        Stream<String> nameStream = peoples.stream();
        nameStream.forEach(System.out::println);

        //crash
        //nameStream.forEach(System.out::println);

        //non terminal
        System.out.println(peoples.stream().filter(v->v.equals("adina")));
        System.out.println(peoples.stream().mapToInt(String::length).sum());

        //moving between streams
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                    //return s.startsWith("b");
                })
                .forEach(s -> System.out.println("forEach: " + s));


        System.out.println("--------------------------------------------");
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("thread pool:"+commonPool.getParallelism());

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));


    }

}
