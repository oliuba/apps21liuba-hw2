package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] array;
    private final int size;

    public ImmutableArrayList(Object[] elements) {
        this.size = elements.length;
        this.array = copyArray(elements);
    }

    public ImmutableArrayList() {
        this.size = 0;
        this.array = new Object[]{};
    }

    public Object[] copyArray(Object[] arr) {
        int length = arr.length;
        Object[] newArr = new Object[arr.length];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] toAdd = {e};
        return addAll(index, toAdd);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index != size) {
            checkIndex(index);
        }
        int newSize = size + c.length;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index; i < index + c.length; i++) {
            newArray[i] = c[i-index];
        }
        for (int i = index + c.length; i < newSize; i++) {
            newArray[i] = array[i-c.length];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);
        Object[] newArray = new Object[size-1];
        int newArrayCounter = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                newArray[newArrayCounter] = array[i];
                newArrayCounter++;
            }
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);
        Object[] newArray = this.toArray();
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return copyArray(array);
    }
}
