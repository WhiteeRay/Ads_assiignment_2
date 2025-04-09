import tests.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("[1] - Test all the methods MyArrayList");
            System.out.println("[2] - Test all the methods MyLinkedList");
            System.out.println("[3] - Test all the methods MyStack");
            System.out.println("[4] - Test all the methods MyQueue");
            System.out.println("[5] - Test all the methods MyMinHeap");
            System.out.println("[0] - EXIT");
            System.out.println("-------------------------------------");
            System.out.println("Enter you choice:");
            int num = Integer.valueOf(sc.nextLine());
            switch(num){
                case 1:
                    System.out.print("MyArrayList methods: ");
                    MyArrayListTest.startTest();
                    break;
                case 2:
                    System.out.print("MyLinkedList methods: ");
                    MyLinkedListTest.startTest();
                    break;
                case 3:
                    System.out.print("MyStack methods: ");
                    MyStackTest.startTest();
                    break;
                case 4:
                    System.out.print("MyQueue methods: ");
                    MyQueueTest.startTest();
                    break;
                case 5:
                    System.out.print("MyMinHeap methods: ");
                    MyMinHeapTest.startTest();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please enter number 1 - 5");
            }

        }
    }
}