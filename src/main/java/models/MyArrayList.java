package models;
import models.interfaces.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] items;
    private int length;

    public MyArrayList() {
        items = new Object[5];
        length = 0;
    }

    @Override
    public void add(T item) {
        if (length == items.length) {
            increaseCapacity();
        }
        items[length++] = item;
    }

    private void increaseCapacity() {
        Object[] newItems = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        items[index] = item;


    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (length == items.length) {
            increaseCapacity();
        }
        for (int i = length; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        length++;


    }

    @Override
    public void addFirst(T item) {
        add(0,item);

    }

    @Override
    public void addLast(T item) {
        add(length,item);

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) items[index];
    }

    private void checkIfEmpty() {
        if (length == 0) {
            throw new NoSuchElementException("The list is empty.");
        }
    }


    @Override
    public T getFirst() {
        checkIfEmpty();
        return (T) items[0];
    }

    @Override
    public T getLast() {
        checkIfEmpty();
        return (T) items[length - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            items[i] = items[i + 1];
        }
        items[length - 1] = null;
        length--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    @Override
    public void removeFirst() {
        remove(0);

    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        for(int i =0 ; i< length;i++){
            for(int j =0; j< length-1-i;j++){
                if(((T) items[j]).compareTo((T)items[j+1])>0){
                    Object temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                }
            }
        }

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (object == null ? items[i] == null : object.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i++) {
            if (items[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = items[i];
        }
        return newArray;
    }

    @Override
    public void clear() {
        items = new Object[5];
        length = 0;

    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            private void checkHasNext() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
            }

            @Override
            public T next() {
                checkHasNext();
                return (T) items[currentIndex++];
            }


        };
    }
}
