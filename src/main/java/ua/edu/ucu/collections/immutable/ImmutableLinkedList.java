package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int size;

    public ImmutableLinkedList(Object[] elements) {
        this.head = new Node();
        this.size = elements.length;
        Node prev = head;
        if (size != 0) {
            head.setValue(elements[0]);
            for (int i = 1; i < size; i++) {
                Node curr = new Node(prev, null, elements[i]);
                prev.setNext(curr);
                prev = curr;
            }
        }
        this.tail = prev;
    }

    public ImmutableLinkedList() {
        this.size = 0;
        this.head = new Node();
        this.tail = head;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return addLast(e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        Object[] toAdd = {e};
        return addAll(index, toAdd);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index != size) {
            checkIndex(index);
        }
        int newSize = size + c.length;
        Object[] newElements = new Object[newSize];
        Node temp = head;
        for (int i = 0; i < index; i++) {
            newElements[i] = temp.getValue();
            temp = temp.getNext();
        }
        for (int i = index; i < index + c.length; i++) {
            newElements[i] = c[i - index];
        }
        for (int i = index + c.length; i < newSize; i++) {
            newElements[i] = temp.getValue();
            temp = temp.getNext();
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node temp = head;
        int currIndex = 0;
        while (currIndex < index) {
            temp = temp.getNext();
            currIndex++;
        }
        return temp.getValue();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        Object[] newElements = new Object[size-1];
        Node temp = head;
        int oldIndex = 0;
        int newIndex = 0;
        while (oldIndex < size) {
            if (oldIndex != index) {
                newElements[newIndex] = temp.getValue();
                newIndex++;
            }
            temp = temp.getNext();
            oldIndex++;
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        Object[] array = this.toArray();
        array[index] = e;
        return new ImmutableLinkedList(array);
    }

    @Override
    public int indexOf(Object e) {
        Node temp = head;
        int currIndex = 0;
        while (temp != null && temp.getValue() != e && currIndex < size) {
            temp = temp.getNext();
            currIndex++;
        }
        if (currIndex < size) {
            return currIndex;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.getValue();
            temp = temp.getNext();
        }
        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(size, e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size-1);
    }
}
