package com.lirik.concurrent.semaphore.queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class CashboxRunner {

    public static void main(String[] args) {

        Semaphore cashboxes = new Semaphore(2);
        cashboxes = cashboxes;

        List<Thread> threads = Stream.of(
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes),
                                             new BuyerThread(cashboxes)
                                     )
                                     .map(target -> new Thread(target))
                                     .peek(thread -> thread.start())
                                     .toList();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
