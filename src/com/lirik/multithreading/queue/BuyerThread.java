package com.lirik.multithreading.queue;

import java.util.Queue;

public class BuyerThread implements Runnable {

    private final Queue<Cashbox> cashboxes;

    public BuyerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashboxes) {
                while (true) {
                    if (!cashboxes.isEmpty()) {
                        Cashbox cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
//                        Thread.sleep(5L);   // вместо этого вызываем метод wait у наших cashboxes

                        cashboxes.wait(5L);

                        /**
                         * Методы notify() и notifyAll() используются после метода wait() чтобы уведомить другие потоки о том, что объект
                         * освободился. Метод notify() уведомляет 1 какой-то рандомный поток, а метод notifyAll() уведомляет все потоки!!!
                         */
                        cashboxes.notifyAll();

                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу ");
//                        Thread.sleep(5L);

                        cashboxes.wait();  // тут ждем пока касса не освободится
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
