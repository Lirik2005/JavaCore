package com.lirik.functionalprogramming.practice;

import java.util.Map;

/**
 * Дана Map<String, Integer>. Найти сумму всех значений длина ключей которых меньше 7 символов.
 */

public class Task_03 {

    public static void main(String[] args) {

        Map<String, Integer> map = Map.of(
                "string1", 1,
                "strin2", 2,
                "string3", 3,
                "string4", 5,
                "strin5", 5
        );

        int sum = map.entrySet().stream()
                     .filter(entry -> entry.getKey().length() < 7)
                     .mapToInt(entry -> entry.getValue().intValue())
                     .sum();
        System.out.println(sum);


    }

}
