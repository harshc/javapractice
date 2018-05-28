package com.hchiplonkar.linkedlists;

class LinkedList {

    static boolean DeleteNodeWithNoHead(Node n) {
        if (n == null || n.Next == null) return false; //nothing to delete
        Node nextNode = n.Next;
        n.Data = nextNode.Data;
        n.Next = nextNode.Next;
        return true;
    }

    /*
    Partition a list around a value
     */
    static Node PartitionAndSortList(Node node, int value) {
        Node lowerHead = null;
        Node greaterHead = null;

        while (node != null) {
            Node nextNode = node.Next;
            if (node.Data < value) {
                node.Next = lowerHead;
                lowerHead = node;
            } else {
                node.Next = greaterHead;
                greaterHead = node;
            }

            node = nextNode;
        }

        if (lowerHead == null) {
            return greaterHead;
        }

        Node head = lowerHead;
        while (lowerHead.Next != null) {
            lowerHead = lowerHead.Next;
        }
        lowerHead.Next = greaterHead;
        return head;
    }
}
