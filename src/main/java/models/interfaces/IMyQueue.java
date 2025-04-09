package models.interfaces;

public interface IMyQueue<T> {
    T peek();
    T enqueue(T item);
    T dequeue();
    int size();
    boolean empty();

}
