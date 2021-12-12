package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            stack.push(i);
        }
    }

    @Test
    public void testConstructor() {
        Object[] elems = {1,2,3};
        stack = new Stack(elems);
        assertEquals(3, stack.peek());
    }

    @Test
    public void pop() {
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void popEmpty() {
        stack = new Stack();
        stack.pop();
    }

    @Test
    public void peek() {
        assertEquals(5, stack.peek());
    }

    @Test
    public void peekEmpty() {
        stack = new Stack();
        assertNull(stack.peek());
    }
}
