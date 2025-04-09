package models;

public class MyStackByLinkedList <T extends Comparable<T>>{
    private MyLinkedList<T> stack;

    public MyStackByLinkedList(){
        stack = new MyLinkedList<>();
    }

    public T push(T newItem){
        stack.addFirst(newItem);
        return newItem;
    }

    public T peek(){
        return stack.get(0);
    }

    public T pop(){
        T removingitem  = peek();
        stack.removeLast();
        return removingitem;
    }
}
