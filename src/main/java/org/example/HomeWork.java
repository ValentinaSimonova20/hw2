package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty() && count != 0) {
            Node current = stack.pop();
            if(current.value <= upperBound) {
                if(current.right != null && current.right.value <= upperBound && !list.contains(current.right.value)) {
                    stack.push(current);
                    stack.push(current.right);
                } else {
                    list.add(current.value);
                    count--;
                }
            } else {
                if(current.left != null) {
                    stack.push(current.left);
                }
            }
        }
        return list;
    }

}
