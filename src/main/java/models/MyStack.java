package models;

import models.interfaces.IMyStack;
import models.interfaces.MyList;

public class MyStack<T> implements IMyStack<T> {
     private MyList<T> stack;

     public MyStack(MyList<T> stack){
         this.stack = stack;
     }



    public T peek(){
         return stack.getLast();
    }

    public T pop(){
         T removingItem = peek();
         stack.removeLast();
         return removingItem;
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean empty() {
        return stack.size()==0;
    }


    @Override
    public T push(T newItem) {
        stack.addLast(newItem);
        return newItem;
    }
}
