package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayListTest {

    @Test
    public void testAddString() {
        DataArrayList list = new DataArrayList();
        list.add("obj");
        assertThat(list.get(0)).isEqualTo("obj");
    }

    @Test
    public void testAddInt() {
        DataArrayList list = new DataArrayList();
        list.add(1);
        assertThat(list.get(0)).isEqualTo(1);
    }

    @Test
    public void testIsEmptyFalse() {
        DataArrayList list = new DataArrayList();
        list.add("obj");
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    public void testIsEmptyTrue() {
        DataArrayList list = new DataArrayList();
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void testSizeIfEmpty() {
        DataArrayList list = new DataArrayList();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void testSizeIfNotEmpty() {
        DataArrayList list = new DataArrayList();
        list.add("obj");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void testSizeIfNotEmptyAndHasMultipleItem() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        list.add("obj4");
        list.add("obj5");
        list.add("obj6");
        list.add("obj7");
        list.add("obj8");
        list.add("obj9");
        assertThat(list.size()).isEqualTo(9);
    }

    @Test
    public void testSizeIfNotEmptyAndAddMultipleItem() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void testIndexOf() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        assertThat(list.indexOf("obj2")).isEqualTo(1);
    }

    @Test
    public void testContainsIsTrue() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        assertThat(list.contains("obj2")).isTrue();
    }

    @Test
    public void testContainsIsFalse() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        assertThat(list.contains("obj4")).isFalse();
    }

    @Test
    public void testRemoveByObjIfValid() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        list.remove("obj3");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void testRemoveByIndexIfValid() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        list.remove(2);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveByObjIfInvalid() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        list.remove("obj4");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexIfInvalid() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.add("obj3");
        list.remove(3);
    }

    @Test
    public void testClear() {
        DataArrayList list = new DataArrayList();
        list.add("obj1");
        list.add("obj2");
        list.clear();
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.get(0)).isEqualTo(null);
    }
}
