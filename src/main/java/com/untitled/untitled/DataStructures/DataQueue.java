package com.untitled.untitled.DataStructures;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class DataQueue implements Queue {

    private static final int DEFAULT_SIZE = 10;

    private Object[] data;
    private int size, front, rear;


    public DataQueue() {
        this.data = new Object[DEFAULT_SIZE];
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }

    public DataQueue(int size) {
        this.data = new Object[size];
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        data[rear++] = o;
        size++;
        if (rear == data.length) {
            increaseDataSize();
        }
        return true;
    }

    private void increaseDataSize() {
        int newSize = data.length * 2;
        data = Arrays.copyOf(data, newSize);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        data = new Object[DEFAULT_SIZE];
        size = front = rear = 0;
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
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        size--;
        Object o = data[front++];
        if (front > 4) {
            reArrangeData();
        }
        return o;

    }

    private void reArrangeData() {
        Object[] newData = new Object[size * 2];
        System.arraycopy(data, front, newData, 0, size);
        data = newData;
        front = 0;
        rear = size;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return data[front];
    }
}
