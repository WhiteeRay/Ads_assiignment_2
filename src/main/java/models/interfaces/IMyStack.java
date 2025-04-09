package models.interfaces;

public interface IMyStack <T> {
    T push(T newItem);
    T peek();
    T pop();
    int size();
    boolean empty();
}

