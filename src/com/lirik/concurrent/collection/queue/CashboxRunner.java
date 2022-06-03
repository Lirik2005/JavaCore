package com.lirik.concurrent.collection.queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class CashboxRunner {

    public static void main(String[] args) {

        BlockingQueue<Cashbox> cashboxes = new ArrayBlockingQueue<>(2, true, List.of(new Cashbox(), new Cashbox()));

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
