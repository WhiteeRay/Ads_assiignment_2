package models;

public class MyNode<T> {
    T data;
    MyNode<T> next;
    MyNode<T> prev;

    public MyNode(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }

    public MyNode<T> getNext(){
        return next;
    }

    public void setNext(MyNode<T> next){
        this.next = next;
    }

    public void setPrev(MyNode<T> prev){
        this.prev = prev;
    }


    public boolean hasNext() {
        return next!=null;
    }
}
