package models;

import models.interfaces.IMyMinHeap;


public class MyMinHeap<T extends Comparable<T>> implements IMyMinHeap<T> {
    private MyArrayList<T> minHeap;




    public MyMinHeap(){
        this.minHeap = new MyArrayList<>();
    }

    private int parent(int index) {
        return (index-1)/2;
    }


    private int leftChild(int index) {
        return (index*2) +1;
    }


    private int rightChild(int index) {
        return (index*2) +2;
    }


    private boolean isleaf(int index) {
        if(leftChild(index) >= size() ){
            return true;
        }
        return false;
    }



    @Override
    public T remove() {
        isEmpty();
        T removed = minHeap.getFirst();
        if (size() == 1){
            minHeap.remove(0);
        } else {
            swap(0, minHeap.size() - 1);
            minHeap.remove(size() - 1);
            minHeapify(0);
        }
        return removed;

    }

    private void isEmpty(){
        if(empty()){
            throw new IllegalStateException("Heap is empty");
        }
    }

    @Override
    public void insert(T item) {
        minHeap.add(item);
        int current = size()-1;

        while(minHeap.get(current).compareTo(minHeap.get(parent(current)))<0){
            swap(current, parent(current));
            current = parent(current);
        }

    }

    private void swap(int x, int y){
        T tmp = minHeap.get(x);
        minHeap.set(x,minHeap.get(y));
        minHeap.set(y,tmp);

    }

    @Override
    public void minHeap() {
        for(int i =((size()-2)/2); i >=0; i--){
            minHeapify(i);
        }

    }

    private void minHeapify(int i) {
        if(!isleaf(i)){
            int leftIndex = leftChild(i);
            int rightIndex = rightChild(i);
            int smallestIndex = i;
            if(leftIndex < size() && minHeap.get(leftIndex)!=null &&
            minHeap.get(i) != null && minHeap.get(i).compareTo(minHeap.get(leftIndex))>0){
                smallestIndex = leftIndex;
            }
            if(rightIndex < size() && minHeap.get(rightIndex)!=null &&
            minHeap.get(i) != null && minHeap.get(i).compareTo(minHeap.get(rightIndex))>0){
                smallestIndex = rightIndex;
            }
            if(smallestIndex != i){
                swap(i,smallestIndex);
                minHeapify(smallestIndex);
            }
        }
    }

    @Override
    public int size() {
        return minHeap.size();
    }

    @Override
    public boolean empty() {
        return minHeap.size() ==0;
    }
}
