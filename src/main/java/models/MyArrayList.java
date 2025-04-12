package models;
import models.interfaces.MyList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] items;
    private int length;
    private int capacity;

    public MyArrayList() {
        items = new Object[capacity];
        length = 0;
        capacity = 10;
    }

    /**
     * Adds the specified element to the end of the list.
     * @param item the element to be added
     */
    @Override
    public void add(T item) {
        if (length == capacity) {
            increaseCapacity();
        }
        items[length++] = item;
    }

    /**
     * Doubles the internal array size to accommodate more elements.
     */
    private void increaseCapacity() {
        Object[] newItems = new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    /**
     * Replaces the element at the specified index with the given item.
     * @param index the index to replace
     * @param item  the element to be set
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        items[index] = item;


    }


    /**
     * Shifts elements to the right to create space at specified position and adds the element there.
     * @param index   the position to insert the element at
     * @param item the element to be inserted at the specified position
     */
    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (length == capacity) {
            increaseCapacity();
        }
        for (int i = length; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        length++;


    }


    /**
     * Adds an element at the beginning of the list.
     * @param item the element to add
     */
    @Override
    public void addFirst(T item) {
        add(0,item);

    }


    /**
     * Adds an element at the end of the list.
     * @param item the element to add
     */
    @Override
    public void addLast(T item) {
        add(length,item);

    }


    /**
     * Returns the element at the specified index.
     * @param index the position to retrieve
     * @return the element at the given index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) items[index];
    }

    /**
     * Checks if the list is empty and throws exception if true.
     */
    private void checkIfEmpty() {
        if (length == 0) {
            throw new NoSuchElementException("The list is empty.");
        }
    }

    /**
     * Returns the first element of the list.
     * @return the first element
     */
    @Override
    public T getFirst() {
        checkIfEmpty();
        return (T) items[0];
    }

    /**
     * Returns the last element of the list.
     * @return the last element
     */
    @Override
    public T getLast() {
        checkIfEmpty();
        return (T) items[length - 1];
    }


    /**
     * Removes the element at the specified index, shifting elements left.
     * @param index the index of the element to remove
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            items[i] = items[i + 1];
        }
        items[length - 1] = null;
        length--;
    }


    /**
     * Validates index is within bounds of list.
     * @param index the index to validate
     */
    private void checkIndex(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }


    /**
     * Removes the first element of the list.
     */
    @Override
    public void removeFirst() {
        remove(0);

    }


    /**
     * Removes the last element of the list.
     */
    @Override
    public void removeLast() {
        remove(length - 1);
    }


    /**
     * Sorts the list using the bubble sort algorithm.
     */
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

    /**
     * Returns the index of the first occurrence of the specified object.
     * @param object the object to search for
     * @return index of the object, or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (object == null ? items[i] == null : object.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Returns the index of the last occurrence of the specified object.
     * @param object the object to search for
     * @return last index of the object, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i++) {
            if (items[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Checks if the list contains the specified object.
     * @param object the object to find
     * @return true if present, otherwise false
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }


    /**
     * Returns a new array containing all elements in the list.
     * @return an array of the list's contents
     */
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = items[i];
        }
        return newArray;
    }


    /**
     * Clears all elements from the list.
     */
    @Override
    public void clear() {
        items = new Object[5];
        length = 0;

    }


    /**
     * Returns the number of elements in the list.
     * @return the list size
     */
    @Override
    public int size() {
        return length;
    }


    /**
     * Returns an iterator over the list elements.
     * @return an iterator for the list
     */
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
