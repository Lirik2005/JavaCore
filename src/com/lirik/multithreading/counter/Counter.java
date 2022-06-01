package com.lirik.multithreading.counter;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 * <p>
 * Добавить методы:
 * - getCount() - для получение поля count
 * - increment() - для увеличения значения поля на единицу
 * - decrement() - для уменьшения значения поля на единицу
 */

public class Counter {

    private static String description;
    private int count;

    /**
     * Таким образом можно синхронизировать статический метод и только > поток сможет его вызвать при необходимости.
     * Также статический метод может быть синхронизирован на уровне метода!!!!
     */

    public static void blockSynchronizedInit() {
        synchronized (Counter.class) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    /**
     * Ключевое слово synchronized говорит, что в один и тот же момент времени у одного и того же объекта метод может вызываться только
     * одним потоком.
     * Ниже приведено использование ключевого слова synchronized на уровне метода. То есть весь метод является синхронизированным!!!
     */

    public synchronized void methodSynchronizedIncrement() {
        count++;
    }

    /**
     * Ниже приведено использование ключевого слова synchronized на уровне блока. В данном случае, this это объект, который мы хотим
     * синхронизировать.
     * Synchronized на уровне блока позволяет синхронизировать не весь метод целиком, а конкретный кусочек кода в нем!!!
     */


    public void blockSynchronizedIncrement() {
        synchronized (this) {
            count++;
        }
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
