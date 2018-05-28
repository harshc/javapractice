package com.hchiplonkar.linkedlists;

import org.testng.annotations.Test;

public class LinkedListTest {
    private Node testList = null;

    private void Setup() {
        int testInput[] = new int[]{4, 7, 1, 3, 10, 11, 35, 23, 44, 8};
        testList = new Node(15);
        for (int aTestInput : testInput) {
            testList.AppendToTail(aTestInput);
        }
    }

    @Test
    public void testPartitionAndSortList() {
        Setup();
        LinkedList.PartitionAndSortList(testList, 11);
    }
}
