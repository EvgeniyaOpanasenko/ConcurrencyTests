package com.ua.model;

/**
 * Created by User on 11/9/2017.
 */
public class BankAccount {

    private int balance = 10;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    int withdraw(int amount) {
        setBalance(balance - amount);
        return balance - amount;
    }

    public void addMoney(int amount) {
        setBalance(getBalance() + amount);
    }
}
