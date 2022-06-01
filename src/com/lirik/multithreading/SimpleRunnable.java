package com.lirik.multithreading;

/**
 * Что бы сделать класс многопоточным надо лишь реализовать интерфейс Runnable.
 * Чтобы в этом потоке выполнялся код надо переопределить метод run() -> аналог main() в многопоточности!!!
 */

public class SimpleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello from SimpleRunnable: " + Thread.currentThread().getName());

    }
}
