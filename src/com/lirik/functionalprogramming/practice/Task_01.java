package com.lirik.functionalprogramming.practice;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Дан список целых чисел. Найти среднее всех нечетных чисел, делящихся на 5.
 */

public class Task_01 {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        /**
         * Мое решение. Если значения не будет, то вывалится exception и дальше программа не пойдет!!!
         */

        double average = integerList.stream()
                                    .filter(integer -> integer % 2 != 0)
                                    .filter(integer -> integer % 5 == 0)
                                    .mapToInt(Integer::intValue)
                                    .average()
                                    .orElseThrow(NullPointerException::new);

        System.out.println(average);

        /**
         * Решение от DMdev. Если значения не будет, то в консоли просто ничего не появится и выполнение программы продолжается.
         */

        OptionalDouble optionalDouble = integerList.stream()
                                                   .filter(integer -> integer % 2 != 0)
                                                   .filter(integer -> integer % 5 == 0)
                                                   .mapToInt(Integer::intValue)
                                                   .average();

        optionalDouble.ifPresent(System.out::println);

        /**
         * Третий вариант. Если значения не будет, то в консоли напечатается 0,0 и выполнение программы продолжается.
         */

        double summaryAverage = integerList.stream()
                                           .filter(integer -> integer % 2 != 0)
                                           .filter(integer -> integer % 5 == 0)
                                           .mapToInt(Integer::intValue)
                                           .summaryStatistics()
                                           .getAverage();

        System.out.println(summaryAverage);
    }
}
