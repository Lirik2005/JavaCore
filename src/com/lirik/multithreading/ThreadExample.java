package com.lirik.multithreading;

public class ThreadExample {

    public static void main(String[] args) {

        SimpleTread simpleTread = new SimpleTread();

        /**
         * С помощью метода getState() можно получить текущее состояние потока
         */

        System.out.println(simpleTread.getName() + ": " + simpleTread.getState());

        /**
         * Поток simpleRunnable сам по себе не самостоятельный и не может существовать без класса Thread.
         * Поэтому, чтобы запустить поток simpleRunnable и выполнить действие внутри, необходимо создать объект класса Thread.
         */

        Thread simpleRunnable = new Thread(new SimpleRunnable());

        /**
         * Простой поток можно создать прямиком в конструкторе как в строке 20!!!
         */

        Thread lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        /**
         * Чтобы запустить поток simpleTread в другом потоке, необходимо вызвать у него метод start(), а не run()!!!
         * Если мы напишем simpleTread.run(), это будет вызов у потока main. То есть main выполнять метод run() у объекта simpleTread!!!
         */

        simpleTread.start();
        System.out.println(simpleTread.getName() + ": " + simpleTread.getState()); // показываем состояние потока
        simpleRunnable.start();
        lambdaThread.start();


        try {
            simpleTread.join();  // позволяет сначала выполнить код из строки 14, а строка 22 выполнится, когда выполнится код из строки 14
            System.out.println(simpleTread.getName() + ": " + simpleTread.getState()); // показываем состояние потока
            simpleRunnable.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());

    }

}
