package com.lirik.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);  // позволяет создать пул потоков из пяти потоков
        Future<Integer> future = threadPool.submit(() -> {
            System.out.println("It's callable");
            return 1;
        });

        threadPool.shutdown(); // ждет выполнения всех задач в threadPool и завершает все потоки.

        threadPool.awaitTermination(1L, TimeUnit.HOURS); // время ожидания shutdown
        System.out.println("main end"); // эта строка выполнится, закончатся задачи или выполнится строка 19

    }

}
