package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryIntSearchTreeTest {

    @Test
    void add() {
        HomeWork tree = new HomeWork();

        tree.add(5);

        for (int i = 0; i < 5; i++) {
            tree.add(i);
        }
        tree.add(5);
        System.out.println(tree.findMaxDigits(3, 4));
    }
}