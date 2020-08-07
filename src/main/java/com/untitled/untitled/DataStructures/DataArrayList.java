package com.untitled.untitled.DataStructures;

import java.util.*;

public class DataArrayList<T> implements List<T> {

    private static int DEFAULT_SIZE = 10;

    private int size;
    private T[] data;

    public DataArrayList() {
        size = 0;
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return data[0] == null;
    }

    @Override
    public boolean contains(Object o) {
        return (indexOf(o) >= 0);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T o) {
        add(size, o);
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index == data.length - 1) {
            grow(size + 1);
        }
        data[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) throws IllegalArgumentException {
        int pos = indexOf(o);
        if (pos >= 0) {
            remove(pos);
            return true;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T o = data[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
            size--;
        }

        return o;
    }

    @Override
    public boolean addAll(Collection c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return true;
    }

    @Override
    public void clear() {
        data = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public T[] toArray(Object[] a) {
        return Arrays.copyOf(data, size);

    }

    private Object[] grow(int minCapacity) {
        return data = Arrays.copyOf(data, minCapacity);
    }
}
