package org.example;

import lombok.SneakyThrows;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

abstract class Car {

    public abstract void run();

    public void run1() {

    }

}

class Automobile extends Car {

    @Override
    public void run() {

    }
}

class Demo implements Runnable{

    Integer data ;

    Demo() {
        data = new Integer(1);
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized(data) {
            System.out.println("Thread:" + Thread.currentThread().getId() + " start");
            Thread.sleep(5000);
            System.out.println("Thread:" + Thread.currentThread().getId() + " end");
        }
    }

};


public class App 
{
    void changeStr(StringBuilder str) {
        str.append("4567");
    }

    public void calAll(Object o, Predicate p) {
        int num = 0;

        if (p.test(o)) {
            System.out.print("value: ");
            System.out.println(o);
        }
    }


    public static void main( String[] args ) throws InterruptedException {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

       t1.start();
       t2.start();

       /*Thread thread = new Thread(() -> {
           System.out.println("Thread:" + Thread.currentThread().getId() + " start");

           for (int i = 0; i < 5; i++) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Thread:" + Thread.currentThread().getId() + " exec");
           }
           System.out.println("Thread:" + Thread.currentThread().getId() + " end");

           System.out.println(Thread.currentThread().getThreadGroup().getName());
       });

        thread.start();
        thread.join(2000);*/

        System.out.println("Main Thread:" + Thread.currentThread().getId() + " end");
        System.out.println(Thread.currentThread().getThreadGroup().getName());

    }
}
