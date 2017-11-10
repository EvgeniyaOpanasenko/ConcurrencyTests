package com.ua.model;

/**
 * Created by User on 11/9/2017.
 */
public class Run {
    public static void main(String[] args) {

        RayanAndMinicaTask task = new RayanAndMinicaTask();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.setName("Rayan");
        thread2.setName("Monica");

        thread1.start();
        thread2.start();

    }
}
