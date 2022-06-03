package com.lirik.concurrent.practice;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Задан массив случайных целых чисел (от 1 до 300)
 * случайной длины (до 1 млн элементов).
 * Найти максимальный элемент в массиве двумя способами: в
 * одном потоке и используя 10 потоков.
 * Сравнить затраченное в обоих случаях время.
 */

public class Task_02 {

    public static void main(String[] args) {

        int[] values = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(301); // Метод генерирует числа от 0 до 300. Число 301 не входит в диапазон!!!
        }

        long startTime = System.currentTimeMillis();
        int max = findMax(values);
        long endTime = System.currentTimeMillis();
        System.out.println("Максимальное число в массиве: " + max + ". Это число найдено за " + (endTime - startTime) + " миллисекунд");
        startTime = System.currentTimeMillis();
        max = findMaxParallel(values);
        endTime = System.currentTimeMillis();
        System.out.println("Максимальное число в массиве: " + max + ". Это число найдено за " + (endTime - startTime) + " миллисекунд");


    }

    private static int findMax(int[] values) {
        return IntStream.of(values).max().orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParallel(int[] values) {
        return IntStream.of(values).parallel().max().orElse(Integer.MIN_VALUE);
    }
}
