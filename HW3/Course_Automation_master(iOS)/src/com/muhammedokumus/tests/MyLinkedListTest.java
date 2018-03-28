package com.muhammedokumus.tests;

import com.muhammedokumus.part3.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void addTest() {
        System.out.println("Add Test:");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.add("Gebze");
        testList.add("Teknik");
        testList.add("Üniversitesi");

        testList.printList();

        System.out.println("Size: " + testList.size());
        assertEquals(3,testList.size());
    }

    @Test
    void removeTest(){
        System.out.println("\nRemove Test:");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.add("Gebze");
        testList.add("Teknik");
        testList.add("Üniversitesi");
        testList.remove(0);


        testList.printList();

        System.out.println("Size: " + testList.size());
        assertEquals(2,testList.size());
    }


    @Test
    void sizeTest(){
        System.out.println("\nSize test:");
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        System.out.println("Size: " + testList.size());
        assertEquals(0,testList.size());

        for(int i = 0; i < 100; i++)
            testList.add(i);

        System.out.println("Size: " + testList.size());
        assertEquals(100,testList.size());

        for(int i = 0; i < 50; i++)
            testList.remove(i);

        System.out.println("Size: " + testList.size());
        assertEquals(50,testList.size());

        for(int i = 0; i < 20; i++)
            testList.remove(i);

        System.out.println("Size: " + testList.size());
        assertEquals(30,testList.size());
    }
}