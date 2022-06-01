package com.lirik.multithreading.account;

public class AccountThread extends Thread {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    /**
     * Тут показана проблема Deadlock!!!
     */

    @Override
    public void run() {
                for (int i = 0; i < 200; i++) {
                    synchronized (accountFrom) {
                        synchronized (accountTo) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }
}