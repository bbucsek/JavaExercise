package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueueTest {

    @Test
    public void testAddToQueueSize() {
        DataQueue q = new DataQueue();
        q.add(1);
        assertThat(q.size()).isEqualTo(1);
    }

    @Test
    public void testAddMultipleToQueueSize() {
        DataQueue q = new DataQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        assertThat(q.size()).isEqualTo(3);
    }

    @Test
    public void testAddMoreItemThanSize() {
        DataQueue q = new DataQueue(2);
        q.add(1);
        q.add(2);
        q.add(3);
        assertThat(q.size()).isEqualTo(3);
    }

    @Test
    public void testIsEmptyTrue() {
        DataQueue q = new DataQueue(2);
        assertThat(q.isEmpty()).isEqualTo(true);
    }

    @Test
    public void testIsEmptyFalse() {
        DataQueue q = new DataQueue(2);
        q.add(1);
        q.add(2);
        q.add(3);
        assertThat(q.isEmpty()).isEqualTo(false);
    }

    @Test
    public void testClear() {
        DataQueue q = new DataQueue();
        q.add(1);
        q.clear();
        assertThat(q.isEmpty()).isEqualTo(true);
    }

    @Test
    public void testAddMultiplePollMultiplePeekMultiple() {
        DataQueue q = new DataQueue(2);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.poll();
        assertThat(q.peek()).isEqualTo(2);
    }

    @Test
    public void testAddMultiplePollMultiplePeekMultiple2() {
        DataQueue q = new DataQueue(2);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.poll();
        q.poll();
        q.add(5);
        q.add(6);
        assertThat(q.peek()).isEqualTo(3);
    }


    @Test
    public void testAddMultiplePollMultiplePeekMultiple3() {
        DataQueue q = new DataQueue(2);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.poll();
        q.poll();
        q.add(5);
        q.add(6);
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.add(10);
        q.add(11);
        assertThat(q.poll()).isEqualTo(10);
        assertThat(q.poll()).isEqualTo(11);
        assertThat(q.poll()).isEqualTo(null);
    }


    @Test
    public void testAddMultiplePollMultiplePeekMultiple4() {
        DataQueue q = new DataQueue(2);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.poll();
        assertThat(q.peek()).isEqualTo(6);
    }

    @Test
    public void testAddMultiplePollMultiplePeekMultiple5() {
        DataQueue q = new DataQueue(2);
        for (int i = 0; i < 2000; i++) {
            q.add(i);
        }
        for (int i = 0; i < 500; i++) {
            q.poll();
        }
        assertThat(q.peek()).isEqualTo(500);
    }




}
