package org.threadt;

import java.util.*;

public class AbRunnable implements Runnable{

    private Deque<Integer> queue;
    //private atmoicInteger integer;

    {
        queue = new ArrayDeque<>();
    }

    public synchronized void add() {
        queue.addLast(1);
    }



    @Override
    public void run() {

    }
}
