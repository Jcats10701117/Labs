package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Random;

public class Person {

    public final String name;
    private int age;
    public final Cash cash;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        cash = new Cash();
    }

    public int getAge() {
        return age;
    }

}
