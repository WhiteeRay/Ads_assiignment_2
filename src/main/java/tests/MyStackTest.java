package tests;

import models.MyArrayList;
import models.MyStack;
import models.interfaces.MyList;

public class MyStackTest {
    public static void startTest() {
        // Test 1: Test push method
        MyList<Integer> myList = new MyArrayList<>();
        MyStack<Integer> stack = new MyStack<>(myList);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test 2: Test size method
        assert stack.size() == 3 : "Size should be 3 after pushing 3 items";

        // Test 3: Test peek method
        assert stack.peek() == 3 : "Peek should return the last pushed item (3)";

        // Test 4: Test pop method
        assert stack.pop() == 3 : "Pop should return the last pushed item (3)";
        assert stack.size() == 2 : "Size should be 2 after popping one item";

        // Test 5: Test empty method
        assert !stack.empty() : "Stack should not be empty after popping one item";

        // Test 6: Pop remaining items
        stack.pop();
        stack.pop();

        // Test 7: Test empty method again
        assert stack.empty() : "Stack should be empty after popping all items";

        // Test 8: Test peek on empty stack (should handle gracefully)
        try {
            stack.peek();
            assert false : "Peek should throw an exception on empty stack";
        } catch (Exception e) {
            // Expected behavior
        }

        // Test 9: Test pop on empty stack
        try {
            stack.pop();
            assert false : "Pop should throw an exception on empty stack";
        } catch (Exception e) {

        }

        System.out.println("All tests passed!");
    }
}