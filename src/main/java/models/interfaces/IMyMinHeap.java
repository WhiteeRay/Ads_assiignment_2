package models.interfaces;

public interface IMyMinHeap<T> {
    void insert(T item);
    T remove();
    void minHeap();
    int size();
    boolean empty();
}
