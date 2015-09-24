package java8;

public class Person {

    private String name;
    private String city;
    private int age;


    public Person(String name,int age,String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return name+" age "+age+" from "+city;
    }
}
