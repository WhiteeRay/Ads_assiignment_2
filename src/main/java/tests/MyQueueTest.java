package tests;

import models.MyLinkedList;
import models.MyQueue;
import models.interfaces.MyList;

public class MyQueueTest {
    public static void startTest() {
        // Test 1: Test enqueue method
        MyList<Integer> myList = new MyLinkedList<>();
        MyQueue<Integer> queue = new MyQueue<>(myList);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Test 2: Test size method
        assert queue.size() == 3 : "Size should be 3 after enqueueing 3 items";

        // Test 3: Test peek method
        assert queue.peek() == 1 : "Peek should return the first enqueued item (1)";

        // Test 4: Test dequeue method
        assert queue.dequeue() == 1 : "Dequeue should return the first enqueued item (1)";
        assert queue.size() == 2 : "Size should be 2 after dequeuing one item";

        // Test 5: Test empty method
        assert !queue.empty() : "Queue should not be empty after dequeuing one item";

        // Test 6: Dequeue remaining items
        queue.dequeue();
        queue.dequeue();

        // Test 7: Test empty method again
        assert queue.empty() : "Queue should be empty after dequeuing all items";

        // Test 8: Test peek on empty queue (should handle gracefully)
        try {
            queue.peek();
            assert false : "Peek should throw an exception on empty queue";
        } catch (Exception e) {

        }

        // Test 9: Test dequeue on empty queue (should handle gracefully)
        try {
            queue.dequeue();
            assert false : "Dequeue should throw an exception on empty queue";
        } catch (Exception e) {

        }

        System.out.println("All tests passed!");
    }
}
