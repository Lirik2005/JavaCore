package com.lirik.collections.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Написать метод, который принимает целочисленный список и возвращает список только с нечетными значениями.
 */

public class Task_01 {

    public static void main(String[] args) {

        List<Integer> sourceList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Исходная коллекция: " + sourceList);
        System.out.println("Конечная коллекция: " + removeEven(sourceList));
    }

    public static List<Integer> removeEven(List<Integer> sourceList) {
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : sourceList) {
            if (integer % 2 != 0) {
                newList.add(integer);
            }
        }
        return newList;
    }
}
