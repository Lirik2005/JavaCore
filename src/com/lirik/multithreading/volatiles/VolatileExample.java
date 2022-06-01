package com.lirik.multithreading.volatiles;

public class VolatileExample {

    /**
     * Ключевое слово volatile используется чтобы не использовать какие-либо системы оптимизации (например кэш процессора). Используя
     * слово volatile, каждый раз, когда мы захотим получить значение поля flag (считать его или изменить) мы будем делать это только из
     * оперативной памяти!!!
     * Ключевое слово volatile работает только для примитивов и ссылок, но содержимое ссылок мы не сможем определить!!!
     */
    private static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("Still false");
            }
        });

        thread1.start();

        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("Flag is set");

        });

        thread2.start();
    }
}
