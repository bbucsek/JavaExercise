package com.untitled.untitled.DataStructureTest;

import com.untitled.untitled.DataStructures.DataBinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinarySearchTreeTest {

    @Test
    public void testContains() {
        DataBinarySearchTree tree = new DataBinarySearchTree();
        tree.add(50);
        tree.add(40);
        tree.add(30);
        tree.add(60);
        tree.add(70);
        assertThat(tree.contains(50)).isTrue();
        assertThat(tree.contains(40)).isTrue();
        assertThat(tree.contains(70)).isTrue();
        assertThat(tree.contains(700)).isFalse();
    }

    @Test
    public void testDelete() {
        DataBinarySearchTree tree = new DataBinarySearchTree();
        tree.add(550);
        tree.add(40);
        tree.add(30);
        tree.add(60);
        tree.add(70);
        assertThat(tree.size()).isEqualTo(5);
        tree.delete(40);
        assertThat(tree.size()).isEqualTo(4);
    }

    @Test
    public void testSize() {
        DataBinarySearchTree tree = new DataBinarySearchTree();
        tree.add(550);
        tree.add(40);
        tree.add(30);
        tree.add(60);
        tree.add(70);
        assertThat(tree.size()).isEqualTo(5);
    }
}
