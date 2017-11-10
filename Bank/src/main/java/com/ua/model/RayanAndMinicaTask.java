package com.ua.model;

/**
 * Created by User on 11/9/2017.
 */
public class RayanAndMinicaTask implements Runnable {

    private BankAccount account = new BankAccount();

    public void run() {
        synchronized (this) {
            for (int x = 0; x < 10; x++) {
                makeWithdrawl(10);
                if (account.getBalance() < 0) {
                    System.out.println("OVerdrawn!");
                }
            }
            for (int x = 0; x < 10; x++) {
                makeAdd(20);
                if (account.getBalance() < 0) {
                    System.out.println("OVerdrawn!");
                }
            }

        }}

    private synchronized void makeWithdrawl(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawl");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }

    private synchronized void makeAdd(int amount) {

        System.out.println(Thread.currentThread().getName() + " is about to add money");
        try {
            System.out.println(Thread.currentThread().getName() + " is going to sleep");
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " woke up.");
        account.addMoney(amount);
        System.out.println(Thread.currentThread().getName() + " completes the add");

        System.out.println("balance is = " + account.getBalance());
    }
}
