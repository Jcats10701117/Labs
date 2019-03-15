package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Random;

public class PersonFactory {
    private Random random;

    public PersonFactory() {
        random = new Random();
    }

    public Person createPerson() {
        return new Person(
                StaticResources.getPersonName(),
                18 + random.nextInt(10)
        );
    }
}
