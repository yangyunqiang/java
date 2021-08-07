package org.threadt;

import java.util.concurrent.*;

public class FutureDemo {
    static  long fibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //FutureTask<Long> task = new FutureTask<>(()->fibonacci(5));
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Long> task = service.submit(() -> fibonacci(6));
        //new Thread(task).start();

        while(!task.isDone()) {
            Thread.sleep(100);
        }

        System.out.println(task.get());
    }
}
