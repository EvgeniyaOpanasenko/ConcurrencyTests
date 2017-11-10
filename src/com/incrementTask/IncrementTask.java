package com.incrementTask;

/**
 * Created by User on 11/9/2017.
 */
public class IncrementTask implements Runnable {
    private int balance;

    public void run() {
        for (int i = 0; i < 500; i++) {
            increment();
            //System.out.println("Thread name " + Thread.currentThread().getName() + " balance is "  + balance);
        }
        System.out.println("Balance  = " + balance);
    }

    private synchronized void increment() {
        int i = balance;
        balance = i + 1;

    }

    public synchronized static void main(String[] args) {
        IncrementTask task = new IncrementTask();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
