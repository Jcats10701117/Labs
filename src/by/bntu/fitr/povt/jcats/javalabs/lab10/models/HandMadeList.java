package by.bntu.fitr.povt.jcats.javalabs.lab10.models;
import java.util.Collection;
import java.util.Iterator;


public class HandMadeList<T> implements Iterable<T>, Collection<T> {
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
    public boolean add(T element){
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0,  newArray, 0, array.length);
        newArray[newArray.length - 1] = element;
        array = newArray;

        return true;
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
    public boolean containsAll(Collection<?> collection) {
        for (var el: array) {
            if (!collection.contains(el)) {
                return false;
            }
        }
        return true;
    }
    public boolean addAll(Collection<? extends T> collection) {
        for (var el : collection) {
            add(el);
        }
        return true;
    }
    public boolean removeAll(Collection<?> collection) {
        for (var el: collection) {
            remove(el);
        }
        return true;
    }
    public boolean retainAll(Collection<?> collection) {
        for (var el: this) {
            if (!collection.contains(el)) {
                remove(el);
            }
        }
        return true;
    }
    public void clear() {
        this.array = new Object[0];
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
    public Iterator<T> iterator(){
        return new HandMadeIterator<>(array);
    }
    public Object[] toArray() {
        return array.clone();
    }
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
}
