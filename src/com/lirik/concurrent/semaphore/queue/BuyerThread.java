package com.lirik.concurrent.semaphore.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    private final Semaphore cashboxes;

    public BuyerThread(Semaphore cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            cashboxes.acquire(); // захватывает монитор объекта
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе в какой-то кассе");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу какую-то кассу");
            cashboxes.release(); // освобождает монитор
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
