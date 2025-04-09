package models;

import models.interfaces.IMyQueue;
import models.interfaces.MyList;

public class MyQueue<T> implements IMyQueue<T>{


    private MyList<T> queue;

    public MyQueue(MyList<T> queue){
        this.queue = queue;
    }

    public T peek(){
        return queue.getFirst();
    }

    public T enqueue(T newItem){
        queue.addFirst(newItem);
        return newItem;
    }

    public T dequeue(){
        T removingItem = peek();
        queue.removeFirst();
        return removingItem;
    }

    @Override
    public int size() {
        return queue.size();
    }


    @Override
    public boolean empty() {
        return queue.size()==0;
    }
}
