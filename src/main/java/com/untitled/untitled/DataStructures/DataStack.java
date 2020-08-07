package com.untitled.untitled.DataStructures;

import java.util.*;

public class DataStack<T> {

    private static int DEFAULT_SIZE = 10;

    private T[] data;
    private int index;

    public DataStack() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
        this.index = -1;
    }

    public DataStack(int size) {
        this.data = (T[]) new Object[size];
        this.index = -1;
    }

    public int size() {
        return index == -1 ? 0 : index + 1;
    }

    public boolean isEmpty() {
        return data[0] == null;
    }

    public boolean contains(T o) {
        for (int i = 0; i < index + 1; i++) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    public void push(T o) {
        if (index + 1 == data.length) {
            increaseStackSize();
        }
        data[++index] = o;
    }

    public boolean remove(T o) {
        if (index == -1) {
            return false;
        }
        remove();
        return true;
    }

    public void clear() {
        data =  (T[]) new Object[DEFAULT_SIZE];
        index = -1;
    }

    public Object remove() throws NoSuchElementException {
        if (index == -1 ) {
            throw new NoSuchElementException();
        }
        return pop();
    }

    public Object pop() {
        return index == -1 ? null : data[index--];
    }

    public Object element() throws NoSuchElementException{
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return peek();
    }

    public Object peek() {
        return index == -1 ? null : data[index];
    }

    private void increaseStackSize() {
        int newSize = data.length * 2;
        data = Arrays.copyOf(data, newSize);
    }
}
