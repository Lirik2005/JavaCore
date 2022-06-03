package com.lirik.concurrent.latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);

        ExecutorService executorService = Executors.newFixedThreadPool(3); // создаем 3 потока

        executorService.submit(new Rocket(countDownLatch));
        Arrays.stream(RocketDetail.values())
              .map(detail -> new RocketDetailRunnable(detail, countDownLatch))
              .forEach(task -> executorService.submit(task));

        executorService.shutdown();  // сигнал к отключению
        executorService.awaitTermination(1L, TimeUnit.MINUTES);
    }

}
