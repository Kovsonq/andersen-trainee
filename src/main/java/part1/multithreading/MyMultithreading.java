package part1.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class MyMultithreading {
    // some wrapped class
    private static Wrapper wrapper = new Wrapper();


    public static void main(String[] args) throws InterruptedException {
        Map<String, Wrapper> threadPool = new HashMap<>();
        Object lock = new Object();

        Runnable runnable = () -> {
            synchronized (lock) {
                try {
                    Thread.currentThread().setName("runnableThread");
                    System.out.println("Start: " + Thread.currentThread().getName());
                    increment();
                    threadPool.put(Thread.currentThread().getName(), new Wrapper(wrapper));
                    System.out.println("Stop: " + Thread.currentThread().getName() + " " + wrapper);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Callable callable = () -> {
            synchronized (lock) {
                try {
                    Thread.currentThread().setName("callableThread");
                    System.out.println("Start: " + Thread.currentThread().getName());
                    increment();
                    threadPool.put(Thread.currentThread().getName(), new Wrapper(wrapper));
                    System.out.println("Stop: " + Thread.currentThread().getName() + " " + wrapper);
                    return null;
                } catch (InterruptedException e) {
                    throw new IllegalStateException("task interrupted", e);
                }
            }
        };

        // 1st way of the thread creating
        Thread myThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.currentThread().setName("myThread");
                    System.out.println("Start: " + Thread.currentThread().getName());
                    increment();
                    threadPool.put(Thread.currentThread().getName(), new Wrapper(wrapper));
                    System.out.println("Stop: " + Thread.currentThread().getName() + " " + wrapper);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myThread.start();

        // 2nd way of the thread creating
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        // 3nd way of the thread creating
        ExecutorService callableExecutorService = Executors.newSingleThreadExecutor();
        Future future = callableExecutorService.submit(callable);
        callableExecutorService.shutdown();

        // 4th way of the thread creating
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        singleExecutorService.submit(() -> {
            synchronized (lock) {
                try {
                    Thread.currentThread().setName("singleExecutorServiceThread");
                    System.out.println("Start: " + Thread.currentThread().getName());
                    increment();
                    threadPool.put(Thread.currentThread().getName(), new Wrapper(wrapper));
                    System.out.println("Stop: " + Thread.currentThread().getName() + " " + wrapper);
                    singleExecutorService.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 5th way of the thread creating
        ExecutorService additionalExecutorService = Executors.newFixedThreadPool(6);
        for (int i = 1; i < 7; i++) {
            int finalI = i;
            additionalExecutorService.submit(() -> {
                synchronized (lock) {
                    try {
                        Thread.currentThread().setName("runnableThread" + " " + finalI);
                        System.out.println("Start: " + Thread.currentThread().getName());
                        increment();
                        threadPool.put(Thread.currentThread().getName(), new Wrapper(wrapper));
                        System.out.println("Stop: " + Thread.currentThread().getName() + " " + wrapper);
                        additionalExecutorService.shutdown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        myThread.join();
        runnableThread.join();
        Thread.sleep(1000);

        System.out.println(" \nMap: " + threadPool.entrySet());

    }

    // one common method which increments some data
    public static void increment() throws InterruptedException {
        wrapper.setBefore(wrapper.getValue());
        wrapper.setTimeBefore((int) System.currentTimeMillis());
        int sum = wrapper.getBefore();
        for (int i = 1; i < 101; i++) {
            wrapper.setValue(sum + i);
            Thread.sleep(1);
        }
        wrapper.setAfter(wrapper.getValue());
        wrapper.setTimeAfter((int) System.currentTimeMillis());
    }

}



