package com.untitled.untitled.DataStructures;

import java.util.NoSuchElementException;

public class DataLinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public DataLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> dataToInsert = new Node<>(data);
        if (head == null) {
            head = dataToInsert;
            tail = dataToInsert;
            size++;
        } else {
            tail.setNext(dataToInsert);
            tail = tail.getNext();
            size++;
        }
    }

    public void add(T data, int index) throws IndexOutOfBoundsException {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(data);
        }
        int counter = 0;
        Node<T> next = head;
        while (counter != index-1) {
            next = next.getNext();
            counter++;
        }
        Node newData = new Node<>(data);
        Node<T> after = next.getNext();
        newData.setNext(after);
        next.setNext(newData);
        size++;
    }

    public void addFirst(T data) {
        Node<T> temp = head;
        head = new Node<>(data);
        head.setNext(temp);
        size++;
    }

    public void addLast(T data) {
        Node<T> dataToInsert = new Node<>(data);
        tail.setNext(dataToInsert);
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> next = head;
        while (counter != index) {
            next = next.getNext();
            counter++;
        }
        return next.getData();
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int indexOf(T data) {
        int index = 0;
        if (data == null) {
            for (Node<T> curr = head; curr != null; curr = curr.getNext()) {
                if (curr.getData() ==  null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> curr = head; curr != null; curr = curr.getNext()) {
                if (curr.getData().equals(data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public boolean contains(T data) {
        /*Node<T> next = head;
        while (next.getNext() != null) {
            if (next.getData().equals(data)) {
                return true;
            }
            next = next.getNext();
        }
        return false;*/
        return indexOf(data) >= 0;
    }

    public T getLast() throws NoSuchElementException {
        Node<T> data = tail;
        if (data == null) {
            throw new NoSuchElementException();
        }
        return data.getData();

    }

    public T getFirst() throws NoSuchElementException {
        Node<T> data = head;
        if (data == null) {
            throw new NoSuchElementException();
        }
        return data.getData();
    }

    public void removeFirst() {
        head = head.getNext();
        size--;
    }

    public void remove(T data) throws NoSuchElementException {
        int index = indexOf(data);
        if (index < 0) {
            throw new NoSuchElementException();
        }
        else if (index == 0) {
            removeFirst();
        } else {
            Node<T> curr = head;
            while (!curr.getNext().getData().equals(data)) {
                curr = curr.getNext();
            }
            if (curr.getNext().equals(tail)) {
                curr.setNext(null);
                tail = curr;
                size--;
            } else {
                Node<T> prev = curr;
                Node<T> next = curr.getNext().getNext();
                prev.setNext(next);
                size--;
            }

        }
    }



}
