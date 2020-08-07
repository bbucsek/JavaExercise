package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackTest {

    @Test
    public void testStackSizeEmpty() {
        DataStack q = new DataStack();
        assertThat(q.size()).isEqualTo(0);
    }

    @Test
    public void testStackSizeOne() {
        DataStack q = new DataStack();
        String test = "test";
        q.push(test);
        assertThat(q.size()).isEqualTo(1);
    }

    @Test
    public void testStackSizeMultiple() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        q.push(test1);
        q.push(test2);
        q.push(test3);
        assertThat(q.size()).isEqualTo(3);
    }

    @Test
    public void testIsEmptyTrue() {
        DataStack q = new DataStack();
        assertThat(q.isEmpty()).isEqualTo(true);
    }

    @Test
    public void testIsEmptyNotTrue() {
        DataStack q = new DataStack();
        String test = "test";
        q.push(test);
        assertThat(q.isEmpty()).isEqualTo(false);
    }

    @Test
    public void testAddOne() {
        DataStack q = new DataStack();
        String test = "test";
        q.push(test);
        assertThat(q.size()).isEqualTo(1);
    }

    @Test
    public void testAddMultiple() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "tes2";
        String test3 = "tes3";
        q.push(test1);
        q.push(test2);
        q.push(test3);
        assertThat(q.size()).isEqualTo(3);
    }

    @Test
    public void testContainsString() {
        DataStack q = new DataStack();
        String test = "test";
        q.push(test);
        assertThat(q.contains(test)).isEqualTo(true);
    }

    @Test
    public void testContainsInteger() {
        DataStack q = new DataStack();
        int test1 = 3;
        int test2 = 2;
        q.push(test1);
        q.push(test2);
        assertThat(q.contains(2)).isEqualTo(true);
    }

    @Test
    public void testPeekWithInteger() {
        DataStack q = new DataStack();
        int test1 = 3;
        int test2 = 2;
        q.push(test1);
        q.push(test2);
        assertThat(q.peek()).isEqualTo(test2);
    }

    @Test
    public void testPeekWithString() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "tes2";
        String test3 = "tes3";
        q.push(test1);
        q.push(test2);
        q.push(test3);
        assertThat(q.peek()).isEqualTo(test3);
    }

    @Test
    public void testPollWithString() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "tes2";
        String test3 = "tes3";
        q.push(test1);
        q.push(test2);
        q.push(test3);
        assertThat(q.pop()).isEqualTo(test3);
        assertThat(q.peek()).isEqualTo(test2);
    }

    @Test
    public void testPollWithInteger() {
        DataStack q = new DataStack();
        int test1 = 3;
        int test2 = 2;
        q.push(test1);
        q.push(test2);
        assertThat(q.pop()).isEqualTo(test2);
        assertThat(q.peek()).isEqualTo(test1);
    }

    @Test
    public void testPollWithMultipleAddAndPoll() {
        DataStack q = new DataStack();
        int test1 = 1;
        int test2 = 2;
        int test3 = 3;
        int test4 = 4;
        q.push(test1);
        q.push(test2);
        q.pop();
        q.push(test3);
        q.push(test4);
        q.pop();
        q.pop();
        assertThat(q.pop()).isEqualTo(test1);
        assertThat(q.peek()).isEqualTo(null);
    }

    @Test
    public void testRemoveIfNotEmpty() {
        DataStack q = new DataStack();
        int test1 = 3;
        int test2 = 2;
        q.push(test1);
        q.push(test2);
        assertThat(q.remove()).isEqualTo(test2);
        assertThat(q.remove()).isEqualTo(test1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveIfEmpty() {
        DataStack q = new DataStack();
        int test1 = 3;
        q.push(test1);
        q.remove();
        q.remove();
    }

    @Test
    public void testClearSize() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "test2";
        q.push(test1);
        q.push(test2);
        q.clear();
        assertThat(q.size()).isEqualTo(0);
    }

    @Test
    public void testClearIsEmpty() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "test2";
        q.push(test1);
        q.push(test2);
        q.clear();
        assertThat(q.isEmpty()).isTrue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testElementEmpty() {
        DataStack q = new DataStack();
        q.element();
    }

    @Test
    public void testElementNotEmpty() {
        DataStack q = new DataStack();
        String test1 = "test1";
        String test2 = "tes2";
        String test3 = "tes3";
        q.push(test1);
        q.push(test2);
        q.push(test3);
        assertThat(q.element()).isEqualTo(test3);
        assertThat(q.element()).isEqualTo(test3);
    }

    @Test
    public void testStackIncrease() {
        DataStack q = new DataStack(2);
        String test1 = "test1";
        q.push(test1);
        q.push(test1);
        q.push(test1);
        assertThat(q.size()).isEqualTo(3);
    }

    @Test
    public void tesMassiveData() {
        DataStack q = new DataStack(2);
        for (int i = 0; i < 2000; i++) {
            q.push(i);
        }
        assertThat(q.size()).isEqualTo(2000);
        assertThat(q.pop()).isEqualTo(1999);
    }

}
