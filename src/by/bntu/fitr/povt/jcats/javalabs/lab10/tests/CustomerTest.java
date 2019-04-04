package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void canTakeAwayOrder() {
        Person p1 = new Person("SomeName", 20);
        Customer customer = new Customer(p1, new DeveloperPlatform());
        String[] apparts = {"Design", "Mobile"};
        Order order = new Order("SomeProject", "SomeApp", customer, 300, apparts );
        Project pr1 = new Project(order);

        customer.takeAwayOrder(pr1);
        Project expected = pr1;

        assertEquals(expected, order);
    }

    @Test
    public void makeOrder() {
    }


}