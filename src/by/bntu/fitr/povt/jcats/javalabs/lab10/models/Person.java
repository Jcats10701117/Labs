package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Random;

public class Person {

    public final String name;
    private int age;
    private int cash;

    public void giveCash(int cash){
        if (cash > 0) {
            this.cash += cash;
        }
    }

    public int takeCash(int size){
        int cashBack;
        if (size >= this.cash){
            cashBack = this.cash;
            this.cash = 0;
        } else {
            this.cash -= size;
            cashBack = size;
        }

        return cashBack;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
