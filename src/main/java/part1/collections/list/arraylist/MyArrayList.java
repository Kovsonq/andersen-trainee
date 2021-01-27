package part1.collections.list.arraylist;

import part1.collections.list.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int capacity = 0;
    private Object[] elementData;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.elementData = new Object[capacity];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.capacity = initialCapacity;
            this.elementData = new Object[capacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal capacity (<0): " + initialCapacity);
        }
    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param item
     * @return
     */
    @Override
    public boolean add(Object item) {
        if (size >= capacity) {
            ensureCapacity();
        }
        elementData[size] = item;
        size++;
        return true;
    }

    /**
     * Resize the capacity of the Array
     */
    private void ensureCapacity() {
        capacity*=2;
        elementData = Arrays.copyOf(elementData, capacity);
    }

    /**
     * Inserts the specified element at the specified position in this list (optional operation).
     * @param index
     * @param item
     */
    @Override
    public void add(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index: " + index);
        } else {
            if (size >= capacity){
                ensureCapacity();
            }
            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }
            elementData[index] = item;
            size++;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index: " + index);
        } else {
            return elementData[index];
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item
     * @return
     */
    @Override
    public int indexOf(Object item) {
        if (item != null){
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(item))
                    return i;
            }
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index
     * @return
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index: " + index);
        } else {
            Object removedElement = elementData[index];
            for (int i = index; i < size; i++) {
                elementData[i] = elementData[i+1];
            }
            size--;
            return removedElement;
        }
    }

    /**
     * Returns the number of elements in this list.
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index
     * @param item
     * @return the element previously at the specified position
     */
    @Override
    public Object set(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index: " + index);
        }
        Object oldElement = elementData[index];
        elementData[index] = item;

        return oldElement;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
