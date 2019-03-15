package by.bntu.fitr.povt.jcats.javalabs.lab10.models;
import java.util.Iterator;


public class HandMadeList<T> implements Iterable<T> {
    private class HandMadeIterator<T> implements Iterator<T>{
        private Object[] array;
        private int index = - 1;
        private HandMadeIterator(Object[] array){
            this.array = array;
        }

        public T next() {
            if (index == array.length - 1) return null;
            return (T)array[++index];
        }

        public boolean hasNext() {
            return index + 1 <= array.length - 1;
        }
    }

    private Object[] array;

    public HandMadeList() {
        array = new Object[0];
    }

    public void add(T element){
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0,  newArray, 0, array.length);
        newArray[newArray.length - 1] = element;
        array = newArray;
    }

    public boolean remove(Object element) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element){ index = i; }
        }

        if (index == -1){
            return false;
        }

        Object[] newArray = new Object[array.length - 1];

        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - (index + 1));

        array = newArray;

        return true;
    }

    public T elementAt(int index) { return (T)array[index]; }

    public int size() { return array.length; }

    public boolean isEmpty() { return array.length == 0; }

    public boolean contains(Object element){
        for (Object el: array){
            if (el == element){ return true; }
        }
        return false;
    }

    public HandMadeIterator<T> iterator(){
        return new HandMadeIterator<>(array);
    }
}
