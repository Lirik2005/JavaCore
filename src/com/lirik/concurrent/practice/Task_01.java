package com.lirik.concurrent.practice;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Написать программу, бесконечно считывающую
 * пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При каждом вводе числа, должна создаваться задача,
 * которая засыпает на введённое число секунд и затем
 * выводит "Я спал N секунд".
 * Однако нужно сделать так, чтобы все задачи выполнялись в
 * одном и том же потоке в порядке ввода.
 * Т.е. в программе есть 2 потока: главный и поток для
 * выполнения всех задач по очереди.
 * При вводе отрицательного числа программа должна завершать свою работу.
 * Второе решение - несколько потоков в пуле. Посчитать кол-во
 * обработанных задач каждым потоком
 */

public class Task_01 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                System.out.println("Введено отрицательное число. Выполнение программы остановлено");
                break;
            }
            threadExecutor.submit(() -> {
                Thread.sleep(seconds * 1000L);
                System.out.printf("Поток %s спал %d секунд-(ы) \n ", Thread.currentThread().getName(), seconds);
                return seconds;
            });
        }
        threadExecutor.shutdown();
        threadExecutor.awaitTermination(10L, TimeUnit.MINUTES);
    }

}

