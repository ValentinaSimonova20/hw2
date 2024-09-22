package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryIntSearchTreeTest {

    @ParameterizedTest
    @MethodSource("source")
    @DisplayName("Поиск массива максимальных значений по рандомном сгенерированному дереву")
    void positiveTest(BinaryIntSearchTreeTestObject testObject) {
        HomeWork tree = new HomeWork();
        int N = 10;
        List<Integer> data = new ArrayList<>(N);
        for(int i = 0; i < N; ++i) {
            data.add(i);
        }
        Collections.shuffle(data);
        data.forEach(tree::add);

        assertEquals(testObject.result, tree.findMaxDigits(testObject.count, testObject.upperBound));
    }

    @ParameterizedTest
    @MethodSource("sourceNegatives")
    @DisplayName("Поиск массива максимальных значений по рандомном сгенерированному дереву с отрицательными значениями")
    void positiveTestWithNegatives(BinaryIntSearchTreeTestObject testObject) {
        HomeWork tree = new HomeWork();
        int N = -100;
        List<Integer> data = new ArrayList<>(N*(-1));
        for(int i = N; i < 0; ++i) {
            data.add(i);
        }
        Collections.shuffle(data);
        data.forEach(tree::add);

        assertEquals(testObject.result, tree.findMaxDigits(testObject.count, testObject.upperBound));
    }

    @Test
    @DisplayName("Некорректный параметр count c отрицательным значением - выкидываем ошибку")
    void incorrectCount() {
        String message = assertThrows(
                IllegalArgumentException.class,
                () -> new HomeWork().findMaxDigits(-5, 100)
        ).getMessage();
        assertEquals("count не должен быть меньше нуля", message);
    }

    private List<BinaryIntSearchTreeTestObject> source() {
        return List.of(
                new BinaryIntSearchTreeTestObject(3, 4, List.of(4, 3, 2)),
                new BinaryIntSearchTreeTestObject(0, 10, List.of()),
                new BinaryIntSearchTreeTestObject(1, 12, List.of(9)),
                new BinaryIntSearchTreeTestObject(100, -1, List.of()),
                new BinaryIntSearchTreeTestObject(12, 10, List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)),
                new BinaryIntSearchTreeTestObject(5, 7, List.of(7, 6, 5, 4, 3))
        );
    }

    private List<BinaryIntSearchTreeTestObject> sourceNegatives() {
        return List.of(
                new BinaryIntSearchTreeTestObject(3, -10, List.of(-10, -11, -12)),
                new BinaryIntSearchTreeTestObject(7, -15, List.of(-15, -16, -17, -18, -19, -20, -21)),
                new BinaryIntSearchTreeTestObject(0, -4, List.of()),
                new BinaryIntSearchTreeTestObject(1, -80, List.of(-80)),
                new BinaryIntSearchTreeTestObject(100, -101, List.of())
        );
    }

    private static class BinaryIntSearchTreeTestObject{
        int count;
        int upperBound;
        List<Integer> result;

        public BinaryIntSearchTreeTestObject(int count, int upperBound, List<Integer> result) {
            this.count = count;
            this.upperBound = upperBound;
            this.result = result;
        }
    }
}