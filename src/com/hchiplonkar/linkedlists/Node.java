package com.hchiplonkar.linkedlists;

class Node {
    Node Next = null;
    int Data;

    Node(int value) {
        Data = value;
    }

    void AppendToTail(int value) {
        Node end = new Node(value);
        Node n = this;
        while (n.Next != null) {
            n = n.Next;
        }
        n.Next = end;
    }
}
