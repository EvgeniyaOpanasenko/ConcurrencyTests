package com.ua;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by User on 11/6/2017.
 */
public class RunnableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
       /* Runnable task = () ->{
         String threadName = Thread.currentThread().getName();
            System.out.println("Hello runnable " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();*/

       /* ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello executor " + threadName);
        });

        executor.shutdown();*/
        /*try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }*/

        //System.out.println("Done" + " " + Thread.currentThread().getName());

       /* Callable<Integer> t = () -> {
          try {
              TimeUnit.SECONDS.sleep(1);
              return 123;
          }catch (InterruptedException e) {
              throw new IllegalStateException("Interrupted task", e);
          }
        };
*/
       /* ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(task);
        //executorService.submit(t);

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 452;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        Integer result = future.get(2, TimeUnit.SECONDS);
        System.out.println(result);

        Future<Integer> f2 = executorService.submit(t);
        Integer r2 = f2.get();
        System.out.println(r2);

        executorService.shutdown();*/

       /* ExecutorService executorService = Executors.newWorkStealingPool();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();*/

        /*callables.add(new Callable<String>() {
                          @Override
                          public String call() throws Exception {
                              return "Hello 1";
                          }
                      });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello 2";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello 3";
            }
        });


        List<Future<String>> futures = executorService.invokeAll(callables);

        for (Future<String> future : futures)
        {
            System.out.println("future.get = " + future.get());
        }*/



       /* List<Callable<String>> callables1 = Arrays.asList(
                ()-> "Hey 1",
                ()-> "Hey 2",
                ()-> "Hey 3"
        );

       List<Future<String>> res = executorService.invokeAll(callables1);

       res.stream()
               .map(future -> {
                   try {
                       return future.get();
                   }
                   catch (Exception e) {
                       throw new IllegalStateException(e);
                   }
               })
               .forEach(System.out::println);*/

       ExecutorService executorService = Executors.newWorkStealingPool();

       List<Callable<String>> callables = Arrays.asList(
               callable("task1", 2),
               callable("task2", 12),
               callable("task3", 3));

       String res = executorService.invokeAny(callables);
        System.out.println(res);
    }


    private static Callable<String> callable(String result, long sleepSeconds) {
            return () -> {
                TimeUnit.SECONDS.sleep(sleepSeconds);
                return result;
            };
        }

    }

