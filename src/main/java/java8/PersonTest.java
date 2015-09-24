package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//import static java.util.Comparator.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PersonTest {

    List<Person> persons = new ArrayList<>();

    public PersonTest() {
        persons.add(new Person("nero",65,"roma"));
        persons.add(new Person("traian",33,"roma"));
        persons.add(new Person("agripina",26,"roma"));
        persons.add(new Person("agripina",6,"pompei"));
        persons.add(new Person("hadrian",26,"pompei"));
        persons.add(new Person("brutus",14,"roma"));
    }

    public void sortPersons7(){
        List<Person> clone = new ArrayList<>(persons);
        Collections.sort(clone, new Comparator<Person>() {
            public int compare(Person x, Person y) {
                return x.getName().compareTo(y.getName());
            }
        });
        System.out.println(clone);
    }

    public void sortPersons8(){
        List<Person> clone = new ArrayList<>(persons);

        //clone.sort(persons, (x, y) -> x.getName().compareTo(y.getName()));
        clone.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println(clone);
    }

    public static void main(String[] args) {

        Comparator<String> cMR = String::compareTo;
        Comparator<String> cMR2 = String::lastIndexOf;
        Callable<ArrayList> callable = ArrayList::new;


        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("nero",65,"roma"));
//        persons.add(new Person("traian",33,"roma"));
//        persons.add(new Person("agripina",26,"roma"));
//        persons.add(new Person("agripina",6,"pompei"));
//        persons.add(new Person("hadrian",26,"pompei"));
//        persons.add(new Person("brutus", 14, "roma"));


        persons.sort(new Comparator<Person>() {
            public int compare(Person x, Person y) {
                return x.getName().compareTo(y.getName());
            }
        });


        System.out.println(persons);

        Collections.sort(persons, (x, y) -> x.getName().compareTo(y.getName()));
        Collections.sort(persons, (x, y) -> x.getName().compareTo(y.getName()));





        Collections.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        persons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

        System.out.println(persons);


        List<Person> filtered = new ArrayList<>();
        int count = 0;
        CheckPersonEligibleForArmyService check = new CheckPersonEligibleForArmyService();

        for (Iterator<Person> i = persons.iterator(); i.hasNext() && count < 2; ) {
            Person data = i.next();
            if (check.test(data)) {
                filtered.add(data);
                count++;
            }
        }

        System.out.println(filtered);

        filtered = persons.stream().filter(check::test).limit(2).collect(Collectors.toList());

        System.out.println(filtered);

        Map<String,List<Person>> cities = new HashMap<>();
        for (Person next : persons) {
            List<Person> personsPerCity = cities.get(next.getCity());
            if (personsPerCity==null) {
                personsPerCity = new ArrayList<>();
                cities.put(next.getCity(), personsPerCity);
            }
            personsPerCity.add(next);
        }
        System.out.println(cities);


        cities = persons.stream().collect(Collectors.groupingBy(Person::getCity));

        System.out.println(cities);

        Integer totalAge = persons
                .stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(totalAge);





    }
}
