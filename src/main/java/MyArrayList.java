import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private Object[] items;
    private int length;

    public MyArrayList(){
        items = new Object[5];
        length = 0;
    }

    @Override
    public void add(T item) {
        if(length==items.length){
            increaseCapacity();
        }
        items[length++] = item;
    }

    private void increaseCapacity(){
        Object[] newItems = new Object[items.length*2];
        for(int i =0;i<items.length;i++){
            newItems[i] = items[i];
        }
        items = newItems;
    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) items[index];
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i< length -1; i++){
            items[i] = items[i+1];
        }
    }

    private void checkIndex(int index){
        if(index <0 || index >= length){
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
