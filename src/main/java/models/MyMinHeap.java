package models;

import models.interfaces.IMyMinHeap;


public class MyMinHeap<T extends Comparable<T>> implements IMyMinHeap<T> {
    private MyArrayList<T> minHeap;




    public MyMinHeap(){
        this.minHeap = new MyArrayList<>();
    }


    /**
     * Returns the index of the parent node of the given index.
     * @param index the index of a node
     * @return the index of its parent
     */
    private int parent(int index) {
        return (index-1)/2;
    }


    /**
     * Returns the index of the left child of the given node.
     * @param index the index of a node
     * @return the index of its left child
     */
    private int leftChild(int index) {
        return (index*2) +1;
    }



    /**
     * Returns the index of the right child of the given node.
     * @param index the index of a node
     * @return the index of its right child
     */
    private int rightChild(int index) {
        return (index*2) +2;
    }


    /**
     * Checks if the node at the given index is a leaf.
     * @param index the index to check
     * @return true if it is a leaf node
     */
    private boolean isleaf(int index) {
        if(leftChild(index) >= size() ){
            return true;
        }
        return false;
    }



    /**
     * Removes and returns the minimum element (root) from the heap.
     * @return the smallest element in the heap
     */
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

    /**
     * Throws an exception if the heap is empty.
     */
    private void isEmpty(){
        if(empty()){
            throw new IllegalStateException("Heap is empty");
        }
    }


    /**
     * Inserts a new element into the heap and reorders to maintain min-heap property.
     * @param item the item to insert
     */
    @Override
    public void insert(T item) {
        minHeap.add(item);
        int current = size()-1;

        while(minHeap.get(current).compareTo(minHeap.get(parent(current)))<0){
            swap(current, parent(current));
            current = parent(current);
        }

    }


    /**
     * Swaps two elements in the heap by their indices.
     * @param x index of first element
     * @param y index of second element
     */
    private void swap(int x, int y){
        T tmp = minHeap.get(x);
        minHeap.set(x,minHeap.get(y));
        minHeap.set(y,tmp);

    }

    /**
     * Builds a min-heap from the current list of elements.
     */
    @Override
    public void minHeap() {
        for(int i =((size()-2)/2); i >=0; i--){
            minHeapify(i);
        }

    }

    /**
     * Restores the min-heap property starting from the given index down the tree.
     * @param i the index from which to start heapifying
     */
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

    /**
     * Returns the number of elements in the heap.
     * @return the minHeap size
     */
    @Override
    public int size() {
        return minHeap.size();
    }


    /**
     * Checks if the heap is empty.
     * @return true if minHeap has no elements
     */
    @Override
    public boolean empty() {
        return minHeap.size() ==0;
    }
}
