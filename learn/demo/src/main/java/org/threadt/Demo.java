package org.threadt;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "," + Thread.currentThread().getName() + ",thread test");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        ExecutorService serviceE = Executors.newCachedThreadPool();

        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        for (int i = 0; i < 10; i++) {
            serviceE.execute(runnable);
        }

        System.out.println(Thread.currentThread().getThreadGroup().activeCount());

        //serviceE.shutdown();
    }

}
