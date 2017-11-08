package com.ua;

/**
 * Created by User on 11/7/2017.
 */
public class Bank {

    private static Account account;

    public static void main(String[] args) {
        account = new Account(25);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Put money " + Thread.currentThread().getName());
                putMoney(10);
            }
        });

        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Put money " + Thread.currentThread().getName());
                putMoney(20);
            }
        });

        thread2.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Get money " + Thread.currentThread().getName());
                getMoney(145);
            }
        });

        thread1.start();

        //System.out.println("Account: " + account.getBalance());
    }

    private synchronized static void putMoney(long sum) {
        account.setBalance(account.checkBalance()+sum);
        System.out.println("Balance: " + account.checkBalance());
    }

    private synchronized static void getMoney(long sum) {
        //account.getBalance();
        if (account.checkBalance()<sum){
            throw new IllegalArgumentException("Need more money");
        }else {
            //account.withdrawal(sum);
            account.setBalance(account.checkBalance()-sum);
            System.out.println("Take your money " + sum);
        }
        System.out.println("Balance: " + account.checkBalance());
    }
}
