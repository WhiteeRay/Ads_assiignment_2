package tests;

import models.MyMinHeap;

public class MyMinHeapTest {
    public static void startTest() {
        // Test 1: Test insert method
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);

        // Test 2: Test size method
        assert minHeap.size() == 4 : "Size should be 4 after inserting 4 items";

        // Test 3: Test empty method
        assert !minHeap.empty() : "Heap should not be empty after inserting items";

        // Test 4: Test remove method
        assert minHeap.remove() == 1 : "Remove should return the smallest item (1)";
        assert minHeap.size() == 3 : "Size should be 3 after removing one item";

        // Test 5: Test remove method again
        assert minHeap.remove() == 3 : "Remove should return the next smallest item (3)";
        assert minHeap.size() == 2 : "Size should be 2 after removing another item";

        // Test 6: Test minHeapify method
        minHeap.insert(4);
        minHeap.insert(2);
        assert minHeap.remove() == 2 : "Remove should return the smallest item (2) after minHeapify";

        // Test 7: Test empty method
        minHeap.remove();
        minHeap.remove();
        assert minHeap.empty() : "Heap should be empty after removing all items";

        // Test 8: Test remove on empty heap
        try {
            minHeap.remove();
            assert false : "Remove should throw an exception on empty heap";
        } catch (IllegalStateException e) {

        }

        // Test 9: Test insert after empty
        minHeap.insert(10);
        assert minHeap.size() == 1 : "Size should be 1 after inserting into an empty heap";
        assert minHeap.remove() == 10 : "Remove should return the only item (10)";

        System.out.println("All tests passed!");
    }
}