package models;

import models.interfaces.MyList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private int length;

    public MyLinkedList() {
        head = null;
        length = 0;
    }


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

    @Override
    public void add(int index, T item) {
        checkInIndex(index);
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            newNode.next = head;
            head = newNode;
        } else {
            MyNode<T> current = head;
            int i = 0;
            while (i <= index - 1) {
                current = current.next;
                i++;

            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;


    }

    private void checkInIndex(int index) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found!");
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);

    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkInIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current.getData();
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(length - 1);
    }

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
//
            }
        }

    }

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

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }


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



    @Override
    public void clear() {
        head = null;
        length = 0;

    }

    @Override
    public int size() {
        return length;
    }

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
