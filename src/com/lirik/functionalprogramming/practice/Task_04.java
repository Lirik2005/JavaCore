package com.lirik.functionalprogramming.practice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.
 * Пример: список {5, 2, 4, 2, 1}
 * Результирующая строка: "52421".
 */

public class Task_04 {

    public static void main(String[] args) {

        List<Integer> integers = List.of(5, 2, 4, 2, 1);

        String result = integers
                .stream()
                .map(integer -> String.valueOf(integer))
                .collect(Collectors.joining());
//                .collect(Collectors.joining(",", "Что-то вначале ", " что-то в конце"));  // метод joining перегружен! Очень удобно

        System.out.println(result);

    }
}