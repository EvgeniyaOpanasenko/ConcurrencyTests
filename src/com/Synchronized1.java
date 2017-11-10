package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by User on 11/7/2017.
 */
public class Synchronized1 {

    private static final int NUM_INCREMENTS = 10;

    private static volatile int count = 0;

    public static void main(String[] args) {
        testSyncIncrement();
        testNonSyncIncrement();
    }

    private static void testSyncIncrement() {

        ExecutorService executor = Executors.newFixedThreadPool(20);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(Synchronized1::incrementSync));

        executor.shutdown();
        System.out.println("   Sync: " + count);
    }

    private static void testNonSyncIncrement() {

        ExecutorService executor = Executors.newFixedThreadPool(20);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(Synchronized1::increment));

        executor.shutdown();

        System.out.println("NonSync: " + count);
    }

    private static void incrementSync() {
        int i = count;
        count = i + 1;
    }

    private static void increment() {
       count = count + 1;
    }

}
