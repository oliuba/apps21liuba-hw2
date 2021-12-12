package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList elems;

    public Queue() {
        this.elems = new ImmutableLinkedList();
    }

    public Queue(Object[] arr) {
        this.elems = new ImmutableLinkedList(arr);
    }

    public Object peek() {
        return elems.getFirst();
    }

    public Object dequeue() {
        Object toRemove = peek();
        this.elems = elems.removeFirst();
        return toRemove;
    }

    public void enqueue(Object e) {
        this.elems = elems.addLast(e);
    }
}
