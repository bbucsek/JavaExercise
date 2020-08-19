package com.untitled.untitled.DataStructures;

import java.util.NoSuchElementException;

public class DataHashMap<K, V> {

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node<K, V> value) {
            this.next = next;
        }
    }

    private static int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private int size;
    private static final int MAX_SIZE = 1 << 20;
    private Node<K, V>[] bucket;

    public DataHashMap() {
        this.bucket = new Node[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public DataHashMap(int capacity) {
        this.bucket = new Node[capacity];
        this.capacity = capacity;
        this.size = 0;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        if (bucket != null) {
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = null;
            }
        }
        size = 0;
        bucket = new Node[DEFAULT_CAPACITY];
    }

    public void put(K key, V value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node<K, V> nodeToAdd = new Node<>(key, value);
        int index = getHashCode(key);
        if (bucket[index] == null) {
            bucket[index] = nodeToAdd;
            size++;
            reSize();
        } else {
            Node<K, V> head = bucket[index];
            while (head.next != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            head.next = nodeToAdd;
            size++;
            reSize();

        }

    }

    private void reSize() throws OutOfMemoryError{
        if (LOAD_FACTOR < (double) size / (double) capacity) {
            if (capacity * 2 >= MAX_SIZE) {
                throw new OutOfMemoryError();
            }
            Node<K, V>[] oldBucket = bucket;
            int oldCapacity = capacity;
            int newCapacity = capacity * 2;
            capacity = newCapacity;
            bucket = new Node[newCapacity];
            size = 0;

            for (int i = 0; i < oldCapacity; i++) {
                if (oldBucket[i] != null) {
                    Node<K, V> curr = oldBucket[i];
                    while (curr != null) {
                        put(curr.key, curr.value);
                        curr = curr.next;
                    }
                }
            }

        }

    }

    public V get(K key) throws NoSuchElementException {
        Node<K, V> curr = bucket[getHashCode(key)];
        if (curr == null) {
            throw new NoSuchElementException();
        }
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return size;
    }


    private int getHashCode(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void remove(K key) throws IllegalArgumentException, NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        get(key);
        int index = getHashCode(key);
        if (bucket[index] == null) {
            throw new IllegalArgumentException();
        }
        Node<K, V> curr = bucket[index];
        if (curr.key.equals(key) && curr.next == null) {
            bucket[index] = null;
            size--;
        } else if (curr.key.equals(key)) {
            bucket[index] = curr.next;
            size--;
        } else {
            while (!curr.next.key.equals(key)) {
                curr = curr.next;
            }
            Node<K, V> prev = curr;
            Node<K, V> next = curr.next.next;
            prev.setNext(next);
            size--;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNullArr() {
        int result = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == null) {
                result++;
            }
        }
        return result;
    }
}


