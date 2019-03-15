package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.HandMadeList;

import java.util.Iterator;

import static org.junit.Assert.*;


public class HandMadeListTest {

    @org.junit.Test
    public void canAddElement() {
        HandMadeList<Integer> list = new HandMadeList<>();

        list.add(5);

        int expected = 5;
        int actual = list.elementAt(0);

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void canRemove() {
        HandMadeList<Integer> list = new HandMadeList<>();

        Integer removingValue = 10;
        Integer expectedNextValue = 20;

        list.add(removingValue);
        list.add(expectedNextValue);

        list.remove(removingValue);

        int actual = list.elementAt(0);

        assertEquals((int)expectedNextValue, actual);
    }

    @org.junit.Test
    public void canGetElementAt() {
        HandMadeList<Integer> list = new HandMadeList<>();

        list.add(10);

        int expected = 10;
        int actual = list.elementAt(0);

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void canResize() {
        HandMadeList<Integer> list = new HandMadeList<>();

        int expectedBefore = 0;
        int actualBefore = list.size();

        assertEquals(expectedBefore, actualBefore);

        list.add(5);

        int expectedAfter = 1;
        int actualAfter = list.size();

        assertEquals(expectedAfter, actualAfter);
    }

    @org.junit.Test
    public void canBeEmpty() {
        HandMadeList<Integer> list = new HandMadeList<>();

        list.add(5);
        list.remove(5);

        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void canCheckContainsElement() {
        HandMadeList<Integer> list = new HandMadeList<>();

        list.add(5);

        assertTrue(list.contains(5));
    }

    @org.junit.Test
    public void canCreateFullIterator() {
        HandMadeList<Integer> list = new HandMadeList<>();

        int[] expectedArray = { 5,6,7 };

        list.add(5);
        list.add(6);
        list.add(7);

        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < 3; i++) {
            int actual = iterator.next();
            int expected = expectedArray[i];
            assertEquals(expected, actual);
        }
    }

    @org.junit.Test
    public void canForEachIterator() {
        HandMadeList<Integer> list = new HandMadeList<>();

        int[] expectedArray = { 5,6,7 };

        list.add(5);
        list.add(6);
        list.add(7);

        int index = 0;

        for (int n: list) {
            int expected = expectedArray[index];
            assertEquals(expected, n);
            index++;
        }
    }
}