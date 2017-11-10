package com.incrementTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 11/9/2017.
 */
public class IncrementTaskExecutor {
    private static int count;

    public static void main(String[] args) {
        runSychr();
        runNotSychr();
    }

    private static void runNotSychr() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            });
        }

        service.shutdown();
        System.out.println("Not Sync Count = " + count);

    }


    private static void runSychr() {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    incrementSync();
                }
            });
        }
        service.shutdown();
        System.out.println("Sync Count = " + count);


    }


    private static void increment() {
        int i = count;
        count = i + 1;
    }
    private synchronized static void incrementSync() {
        int i = count;
        count = i + 1;
    }
}
