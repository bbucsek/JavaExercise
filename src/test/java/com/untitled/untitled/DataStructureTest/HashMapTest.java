package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashMapTest {

    @Test
    public void testPut() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        map.put("test1", 1);
        map.put("test2", 2);
        map.put("test3", 3);
        assertThat(map.size()).isEqualTo(3);
    }

    @Test
    public void testPutLot() {
        DataHashMap<Integer, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 50000; i++) {
            map.put(i, i+i);
        }
        assertThat(map.size()).isEqualTo(50000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutLotAndNull() {
        DataHashMap<Integer, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 500; i++) {
            map.put(i, i+i);
        }
        map.put(null, 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetWrongKey() {
        DataHashMap<Integer, Integer> map = new DataHashMap<>();
        map.put(1, 2);
        map.get(500000);
    }

    @Test
    public void testOneKey() {
        DataHashMap<Integer, Integer> map = new DataHashMap<>();
        map.put(1,2);
        assertThat(map.get(1)).isEqualTo(2);
    }

    @Test
    public void testGetLot() {
        DataHashMap<Integer, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 500; i++) {
            map.put(i, i+i);
        }
        assertThat(map.size()).isEqualTo(500);
        assertThat(map.get(400)).isEqualTo(800);
    }

    @Test
    public void testGetLot2() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 500; i++) {
            map.put(String.valueOf(i), i+i);
        }
        assertThat(map.size()).isEqualTo(500);
        assertThat(map.get("400")).isEqualTo(800);
    }

    @Test
    public void testIsEmptyTrue() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        assertThat(map.isEmpty()).isTrue();
    }

    @Test
    public void testIsEmptyFalse() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), i+i);
        }
        assertThat(map.isEmpty()).isFalse();
    }

    @Test
    public void testClear() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 7500; i++) {
            map.put(String.valueOf(i), i+i);
        }
        assertThat(map.isEmpty()).isFalse();
        map.clear();
        assertThat(map.isEmpty()).isTrue();
        assertThat(map.size()).isEqualTo(0);
    }


    @Test
    public void testAddALot() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(String.valueOf(i), i+i);
        }
        assertThat(map.get("80000")).isEqualTo(160000);
        assertThat(map.get("50000")).isEqualTo(100000);
    }

    @Test
    public void testAddALotOracleHashMap() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(String.valueOf(i), i+i);
        }
        assertThat(map.get("80000")).isEqualTo(160000);
        assertThat(map.get("50000")).isEqualTo(100000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i), i+i);
        }
        map.remove(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNotContainKey() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i), i+i);
        }
        map.remove("should fail");
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 2; i++) {
            map.put(String.valueOf(i), i+i);
        }
        map.remove("1");
        map.get("1");
    }

    @Test
    public void testRemoveLotValue() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 20000; i++) {
            map.put(String.valueOf(i), i);
        }
        for (int i = 0; i < 19990; i++) {
            map.remove(String.valueOf(i));
        }
        assertThat(map.get("19999")).isEqualTo(19999);
    }

    @Test
    public void testSize() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 20000; i++) {
            map.put(String.valueOf(i), i);
        }
        assertThat(map.size()).isEqualTo(20000);
    }


}
