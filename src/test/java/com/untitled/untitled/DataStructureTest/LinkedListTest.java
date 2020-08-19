package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataLinkedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkedListTest {

    @Test
    public void testSize() {
        DataLinkedList<String> list = new DataLinkedList<>();
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        list.add(test1);
        list.add(test2);
        list.add(test3);
        assertThat(list.size()).isEqualTo(3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddItemInvalidToIndex() {
        DataLinkedList<String> list = new DataLinkedList<>();
        String test1 = "test1";
        list.add(test1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddItemInvalidToIndex2() {
        DataLinkedList<String> list = new DataLinkedList<>();
        String test1 = "test1";
        list.add(test1, -1);
    }

    @Test
    public void testAddFirst() {
        DataLinkedList<String> list = new DataLinkedList<>();
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        list.add(test1);
        list.add(test2);
        list.addFirst(test3);
        assertThat(list.size()).isEqualTo(3);

    }

    @Test
    public void testAddToIndex1() {
        DataLinkedList<String> list = new DataLinkedList<>();
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        list.add(test1);
        list.add(test2);
        list.add(test3, 1);
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(test3);
    }

    @Test
    public void testAddToIndex2() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        list.add(666, 250);
        assertThat(list.size()).isEqualTo(501);
        assertThat(list.get(250)).isEqualTo(666);
    }

    @Test
    public void testAddLast() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        list.addLast(1200);
        assertThat(list.get(500)).isEqualTo(1200);
    }

    @Test
    public void testClear1() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.size()).isEqualTo(500);
        list.clear();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test(expected = NullPointerException.class)
    public void testClear2() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        list.clear();
        list.get(0);
    }

    @Test
    public void testGetFirst() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.getFirst()).isEqualTo(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstEmpty() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        list.getFirst();
    }

    @Test
    public void testGetLast() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.getLast()).isEqualTo(499);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastEmpty() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        list.getLast();
    }

    @Test
    public void testContains() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.contains(10)).isTrue();
        assertThat(list.contains(100)).isTrue();
        assertThat(list.contains(240)).isTrue();
    }

    @Test
    public void testNotContains() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.contains(600)).isFalse();
    }

    @Test
    public void testIndexOf() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.indexOf(240)).isEqualTo(240);
    }

    @Test
    public void testRemoveFirst() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        list.removeFirst();
        assertThat(list.size()).isEqualTo(499);
        assertThat(list.get(0)).isEqualTo(1);
    }

    @Test
    public void testRemove() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 1; i < 501; i++) {
            list.add(i);
        }
        list.remove(10);
        assertThat(list.size()).isEqualTo(499);
        assertThat(list.get(9)).isEqualTo(11);
    }

    @Test
    public void testRemoveLast() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 1; i < 501; i++) {
            list.add(i);
        }
        list.remove(500);
        list.remove(450);
        list.remove(499);
        assertThat(list.size()).isEqualTo(497);
        assertThat(list.get(496)).isEqualTo(498);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNull() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        list.remove(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveInvalid() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        list.remove(1000);
    }




}
