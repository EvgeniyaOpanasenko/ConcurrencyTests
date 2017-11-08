package com.ua;

/**
 * Created by User on 11/7/2017.
 */
public class Account {

    private volatile long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public synchronized long checkBalance() {
        return getBalance();
    }
}
