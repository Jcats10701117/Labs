package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Person;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.PersonFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonFactoryTest {

    @Test
    public void canCreatePerson() {
        PersonFactory personFactory = new PersonFactory();
        Person somePerson = personFactory.createPerson();

        assertNotNull(somePerson);
    }
}