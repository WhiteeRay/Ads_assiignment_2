package tests;

import models.MyArrayList;

import java.util.Iterator;

public class MyArrayListTest {
    public static void startTest() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Test add(T)
        list.add(5);
        list.add(3);
        list.add(8);
        assert list.size() == 3 : "Size should be 3";

        // Test get(index)
        assert list.get(0) == 5 : "get(0) should be 5";
        assert list.get(2) == 8 : "get(2) should be 8";

        // Test add(index, T)
        list.add(1, 10);
        assert list.get(1) == 10 : "add at index 1 should be 10";

        // Test addFirst, addLast
        list.addFirst(99);
        list.addLast(100);
        assert list.getFirst() == 99 : "First should be 99";
        assert list.getLast() == 100 : "Last should be 100";

        // Test set
        list.set(0, 42);
        assert list.get(0) == 42 : "set(0) should be 42";

        // Test remove(index)
        list.remove(1);
        assert list.get(1) == 10 : "After removing index 1, it should be 10";

        // Test removeFirst, removeLast
        list.removeFirst();
        list.removeLast();
        assert list.getFirst() == 10 : "First should now be 10";
        assert list.getLast() == 8 : "Last should now be 8";

        // Test sort
        list.sort();
        assert list.get(0) == 3 : "After sort, first should be 3";
        assert list.get(2) == 10 : "After sort, last should be 10";


        list.add(8); // 3, 8, 10, 8
        assert list.indexOf(8) == 1 : "First 8 at index 1";
        assert list.lastIndexOf(8) == 3 : "Last 8 at index 3";

        // Test exists
        assert list.exists(10) : "10 should exist";
        assert !list.exists(999) : "999 should not exist";

        // Test toArray
        Object[] array = list.toArray();
        assert array.length == list.size() : "Array length should match size";

        // Test iterator
        Iterator<Integer> iterator = list.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        assert sum == 29 : "Sum should be 3 + 8 + 10 + 8 = 29";

        // Test clear
        list.clear();
        assert list.size() == 0 : "List should be empty after clear";

        System.out.println("All tests passed!");
    }
}
