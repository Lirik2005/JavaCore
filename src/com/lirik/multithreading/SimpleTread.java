package com.lirik.multithreading;

/**
 * Что бы сделать класс многопоточным надо лишь унаследовать класс Thread.
 * Чтобы в этом потоке выполнялся код надо переопределить метод run() -> аналог main() в многопоточности!!!
 */

public class SimpleTread extends Thread {

    /**
     * Записи в строках 16 и 17 одинаковые. Так как мы унаследовали класс Thread в нашем классе SimpleTread уже есть метод getName()!!!
     */

    @Override
    public void run() {
//        System.out.println("Hello from simpleTread: " + Thread.currentThread().getName());
        System.out.println("Hello from SimpleTread: " + getName());
    }
}
