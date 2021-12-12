package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAddEnd() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableLinkedList newLinkedList = linkedList.add(1);
        Object[] old = {};
        Object[] expected = {1};
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testAddIndex() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,2,3,4};
        ImmutableLinkedList newLinkedList = linkedList.add(2, 3);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testAddAllEnd() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,2,4,5,6};
        Object[] toAdd = {5,6};
        ImmutableLinkedList newLinkedList = linkedList.addAll(toAdd);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testAddAllIndex() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,5,6,2,4};
        Object[] toAdd = {5,6};
        ImmutableLinkedList newLinkedList = linkedList.addAll(1, toAdd);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,5,6,2,4};
        Object[] toAdd = {5,6};
        ImmutableLinkedList newLinkedList = linkedList.addAll(10, toAdd);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testGet() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals(1, linkedList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals(1, linkedList.get(10));
    }

    @Test
    public void testRemove() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,4};
        ImmutableLinkedList newLinkedList = linkedList.remove(1);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testRemoveOneElem() {
        Object[] old = {1};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {};
        ImmutableLinkedList newLinkedList = linkedList.remove(0);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,4};
        ImmutableLinkedList newLinkedList = linkedList.remove(10);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testSet() {
        Object[] old = {1,2,4};
        ImmutableLinkedList arrayList = new ImmutableLinkedList(old);
        Object[] expected = {1,3,4};
        ImmutableLinkedList newLinkedList = arrayList.set(1, 3);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,3,4};
        ImmutableLinkedList newLinkedList = linkedList.set(10, 3);
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testIndexOfNormal() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        int got = linkedList.indexOf(2);
        assertEquals(1, got);
    }

    @Test
    public void testIndexOfAbsent() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        int got = linkedList.indexOf(3);
        assertEquals(-1, got);
    }

    @Test
    public void testSize() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void testSizeEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testClear() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {};
        ImmutableLinkedList newLinkedList = linkedList.clear();
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void isEmptyFalse() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void isEmptyTrue() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testAddFirst() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        ImmutableLinkedList newLinkedList = linkedList.addFirst(0);
        Object[] expected = {0,1,2,4};
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testAddLast() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        ImmutableLinkedList newLinkedList = linkedList.addLast(5);
        Object[] expected = {1,2,4,5};
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testGetHead() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals("1", linkedList.getHead().toString());
    }

    @Test
    public void testGetTail() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals("4", linkedList.getTail().toString());
    }

    @Test
    public void testGetFirst() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        assertEquals(4, linkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {2,4};
        ImmutableLinkedList newLinkedList = linkedList.removeFirst();
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testRemoveFirstOneElem() {
        Object[] old = {1};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {};
        ImmutableLinkedList newLinkedList = linkedList.removeFirst();
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testRemoveLast() {
        Object[] old = {1,2,4};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {1,2};
        ImmutableLinkedList newLinkedList = linkedList.removeLast();
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }

    @Test
    public void testRemoveLastOneElem() {
        Object[] old = {1};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(old);
        Object[] expected = {};
        ImmutableLinkedList newLinkedList = linkedList.removeLast();
        assertArrayEquals(expected, newLinkedList.toArray());
        assertArrayEquals(old, linkedList.toArray());
    }
}