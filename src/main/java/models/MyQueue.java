package models;

import models.interfaces.IMyQueue;
import models.interfaces.MyList;

public class MyQueue<T> implements IMyQueue<T>{


    private MyList<T> queue;

    public MyQueue(MyList<T> queue){
        this.queue = queue;
    }


    /**
     * Retrieves, but does not remove, the head of this queue.
     * @return the front element of the queue
     */
    public T peek(){
        return queue.getFirst();
    }


    /**
     * Inserts the specified element into this queue.
     * @param newItem the element to be added
     * @return the element that was added
     */
    public T enqueue(T newItem){
        queue.addFirst(newItem);
        return newItem;
    }


    /**
     * Retrieves and removes the head (front) of this queue.
     * @return the element that was removed
     */
    public T dequeue(){
        T removingItem = peek();
        queue.removeFirst();
        return removingItem;
    }

    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Returns true if the queue contains no elements.
     * @return true if this queue is empty
     */
    @Override
    public boolean empty() {
        return queue.size()==0;
    }
}
