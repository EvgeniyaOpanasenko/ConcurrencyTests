package com.ua;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 11/7/2017.
 */
public class SynchronizationTest {
    private static volatile int count = 0;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable tas1 = new Runnable() {
            @Override
            public void run() {
                increment();
            }
        };

        Runnable tas2 = new Runnable() {
            @Override
            public void run() {
                increment();
            }
        };

        Runnable tas3 = new Runnable() {
            @Override
            public void run() {
                increment();
            }
        };

        executor.submit(tas1);
        executor.submit(tas2);
        executor.submit(tas3);

        executor.shutdown();

        System.out.println(count);

    }

    private static void increment() {
        count = count +1;
    }
}
