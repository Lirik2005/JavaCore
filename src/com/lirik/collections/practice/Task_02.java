package com.lirik.collections.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Написать метод countUnique, который принимает целочисленный список в качестве параметра и возвращает количество уникальных (т. е. без
 * дубликатов) целых чисел в этом списке.
 * При получении пустого списка метод должен вернуть 0.
 */

public class Task_02 {

    public static void main(String[] args) {
        List<Integer> sourceList = Arrays.asList(1, 2, 3, 3, 4, 2, 5, 6, 7);
        System.out.println(countUnique(sourceList));
    }

    public static int countUnique(List<Integer> sourceList) {
        Set<Integer> set = new HashSet<>(sourceList);
        return set.size();

//        return new HashSet<>(sourceList).size();   // можно и так записать!!!
    }
}
