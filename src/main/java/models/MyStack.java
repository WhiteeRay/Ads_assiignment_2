package models;

import models.interfaces.IMyStack;
import models.interfaces.MyList;

public class MyStack<T> implements IMyStack<T> {
     private MyList<T> stack;

     public MyStack(MyList<T> stack){
         this.stack = stack;
     }


    /**
     * Returns the element on the top of the stack without removing it.
     * @return the top element of the stack
     */
    public T peek(){
         return stack.getLast();
    }

    /**
     * Removes and returns the element on the top of the stack.
     * @return the removed top element
     */
    public T pop(){
         T removingItem = peek();
         stack.removeLast();
         return removingItem;
    }

    /**
     * Returns the number of elements in the stack.
     * @return the size of the stack
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Checks whether the stack is empty.
     * @return true if the stack contains no elements
     */
    @Override
    public boolean empty() {
        return stack.size()==0;
    }



    /**
     * Adds a new element to the top of the stack.
     * @param newItem the element to be pushed onto the stack
     * @return the element that was added
     */
    @Override
    public T push(T newItem) {
        stack.addLast(newItem);
        return newItem;
    }
}
