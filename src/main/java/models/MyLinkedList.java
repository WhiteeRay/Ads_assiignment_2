package models;

import models.interfaces.MyList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        length = 0;
    }


    /**
     * Adds an element to the end of the list.
     * @param item the element to be added
     */
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
        } else {
            MyNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }
        length++;

    }


    /**
     * Replaces the element at the specified index with the given item.
     * @param index the index to replace
     * @param item  the element to be set
     */
    @Override
    public void set(int index, T item) {
        checkInIndex(index);
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head.next;
            head = newNode;
        } else {
            MyNode<T> current = head;
            int i = 0;
            while (i <= index - 1) {
                current = current.next;
                i++;
            }
            newNode.next = current.next.next;
            current.next = newNode;

        }

    }


    /**
     * Inserts new element between two nodes.
     * @param index   the position to insert the element at
     * @param element the element to be inserted at the specified position
     */
    @Override
    public void add(int index, T element) {
        checkInIndex(index);
        if (index == 0) {
            addFirst(element);
        } else if (index == length - 1) {
            addLast(element);
        } else {
            MyNode<T> newNode = new MyNode<>(element);
            MyNode<T> next = traverse(index);
            MyNode<T> previous = traverse(index-1);
            previous.setNext(newNode);
            newNode.setNext(next);
            next.setPrev(newNode);
            length++;
        }
    }

    /**
     * Private method that returns the node at specified index by traversing to it from the head. <br>
     * O(n) time complexity.
     * @param index the index to traverse to
     * @return the node at that specified index
     */
    private MyNode<T> traverse(int index) {
        MyNode<T> next = head;
        for (int i = 0; i < index; i++) {
            next = next.getNext();
        }

        return next;
    }

    /**
     * Throws IndexOutOfBoundsException if index is invalid.
     * @param index the index to validate
     */
    private void checkInIndex(int index) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found!");
        }
    }

    /**
     * Adds an element at the beginning of the list.
     * @param item the element to add
     */
    @Override
    public void addFirst(T item) {
        add(0, item);

    }

    /**
     * Adds an element at the end of the list.
     * @param item the element to add
     */
    @Override
    public void addLast(T item) {
        add(item);
    }


    /**
     * Returns the element at the specified index.
     * @param index the position to retrieve
     * @return the element at the given index
     */
    @Override
    public T get(int index) {
        checkInIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current.getData();
    }


    /**
     * Returns the first element of the list.
     * @return the first element
     */
    @Override
    public T getFirst() {
        return get(0);
    }


    /**
     * Returns the last element of the list.
     * @return the last element
     */
    @Override
    public T getLast() {
        return get(length - 1);
    }


    /**
     * Removes the element at the specified index.
     * @param index the index of the element to remove
     */
    @Override
    public void remove(int index) {
        checkInIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        length--;


    }

    /**
     * Removes the first element from the list.
     */
    @Override
    public void removeFirst() {
        remove(0);


    }

    /**
     * Removes the last element from the list.
     */
    @Override
    public void removeLast() {
        remove(length - 1);
    }



    /**
     * Sorts the list using bubble sort algorithm.
     */
    @Override
    public void sort() {
        for(int i =0 ; i < length;i++){
            MyNode<T> current = head;
            MyNode<T> currentNext = head.next;
            for(int j =0 ; j < length -1;j++){
                if(current.data.compareTo(currentNext.data)>0) {
                    T temp = current.getData();
                    current.setData(currentNext.getData());
                    currentNext.setData(temp);
                }
                current = currentNext;
                currentNext = currentNext.next;
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
        MyNode<T> node = head;
        int i = 0;
        while (i < length) {
            if ((object == null && node.data == null) ||
                    (object != null && object.equals(node.data))) {
                return i;
            }
            node = node.next;
            i++;
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
        int index = 0;
        int lastIndex = -1;
        MyNode<T> current = head;
        while(current != null){
            if(object == null && current.data== null ||
            object!=null && object.equals(current.data)){
                lastIndex = index;
            }
            current = current.next;
            index++;

        }

        return lastIndex;
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
        MyNode<T> current = head;
        int i =0;
        while(current != null){
            newArray[i] = current.data;
            current = current.next;
            i++;

        }

        return newArray;
    }


    /**
     * Clears all elements from the list.
     */
    @Override
    public void clear() {
        head = null;
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
            private MyNode<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            private void checkHasNext() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
            }


            @Override
            public T next() {
                checkHasNext();
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }

        };
    }
}
