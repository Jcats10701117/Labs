package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Person {

    public final String name;
    private int age;
    public final BankAccount bankAccount;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        bankAccount = new BankAccount();
    }

    public int getAge() {
        return age;
    }

}
