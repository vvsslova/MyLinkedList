package com.github.vvsslova;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(0, 3);
        testList.add(1, 4);
        testList.add(2, 1);
        testList.add(0, 5);
        testList.getElements();
        testList.add(1, 2);
        testList.getElements();
        testList.add(3,9);
        testList.getElements();
        testList.add(4, 8);
        testList.getElements();
//        testList.getReversedOrderElements();
        testList.get(3);
        testList.get(6);
        testList.remove(4);
        testList.getElements();
    }
}
