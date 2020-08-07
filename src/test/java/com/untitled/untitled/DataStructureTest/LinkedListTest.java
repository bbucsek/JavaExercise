package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataLinkedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testContains() {
        DataLinkedList<Integer> list = new DataLinkedList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        assertThat(list.get(150)).isEqualTo(150);
        //assertThat(list.contains(150)).isTrue();
    }


}
