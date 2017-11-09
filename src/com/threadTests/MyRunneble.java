package com.threadTests;

/**
 * Created by User on 11/8/2017.
 */
public class MyRunneble implements Runnable{
    @Override
    public void run() {
        work();
    }

    private void work() {
        Thread.currentThread().setName("Kira");
        System.out.println("Hello from my thread " + Thread.currentThread().getName());
        System.out.println();
       // doMore();
    }

    private void doMore() {
        System.out.println("Ya ba da ba du");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunneble());
        thread.start();

        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
