package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryIntSearchTreeTest {

    @Test
    void add() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();

        tree.add(5);

        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);
    }
}