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

    @org.junit.Test
    public void canConvertToArray() {
        var list = new HandMadeList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        var expected = new Integer[] {1,2,3};
        var actual = list.toArray();

        assertArrayEquals(expected, actual);
    }

    @org.junit.Test
    public void canAddAll() {
        var list = new HandMadeList<Integer>();
        var addedList = new HandMadeList<Integer>();
        addedList.add(1);

        list.addAll(addedList);

        var actual = (int)list.elementAt(0);
        var expected = 1;

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void canCheckContainsAll() {
        var list = new HandMadeList<Integer>();
        var containsCollection = new HandMadeList<Integer>();

        containsCollection.add(1);
        containsCollection.add(2);
        containsCollection.add(3);

        list.add(1);
        list.add(2);
        list.add(3);

        var actual = list.containsAll(containsCollection);

        assertTrue(actual);
    }

    @org.junit.Test
    public void canClear() {
        var list = new HandMadeList<Integer>();

        list.add(1);
        list.clear();

        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void canRemoveAll() {
        var list = new HandMadeList<Integer>();

        var removeList = new HandMadeList<Integer>();
        removeList.add(1);
        removeList.add(2);
        removeList.add(3);

        list.add(1);
        list.add(2);
        list.add(3);

        list.removeAll(removeList);

        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void canRetailAll() {
        var list = new HandMadeList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        var retailList = new HandMadeList<Integer>();

        retailList.add(1);
        retailList.add(2);
        retailList.add(3);

        list.retainAll(retailList);

        assertEquals(retailList.size(), list.size());
    }
}