package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

//    @Test
//    public void acceptPayment() {
//        Person p1 = new Person("SomeName", 20);
//        p1.acceptPayment(200);
//
//        int expected = 200;
//        int actual = p1.getCash();
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void giveNegativeCash() {
//        Person p1 = new Person("SomeName", 20);
//        p1.acceptPayment(-200);
//
//        int expected = 0;
//        int actual = p1.getCash();
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void takeCashSmallerThanPersonsCash() {
//        Person p1 = new Person("SoName", 20);
//
//        p1.acceptPayment(200);
//
//        int actual = p1.takePayment(50);
//        int expected = 50;
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void takeCashBiggerThanPersonsCash() {
//        Person p1 = new Person("SomeName", 20);
//
//        p1.acceptPayment(200);
//
//        int actual = p1.takePayment(500);
//        int expected = 200;
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void canGetAge() {
        Person p1 = new Person("SomeName", 20);

        int expected = 20;
        int actual = p1.getAge();

        assertEquals(expected, actual);
    }
}