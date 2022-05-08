package com.xh.juc;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Xiao Hong on 2022-03-09
 * </p>
 */
public class LimitedRun {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10 && !Thread.currentThread().isInterrupted(); i++) {
                System.out.println("i--->" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("time out stop ");
                    return;
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.timedJoin(thread, 2);
        thread.interrupt();

        ReentrantLock reentrantLock = new ReentrantLock();
        LinkedList<Integer> linkedList = new LinkedList<>();
        // producer
        new Thread(() -> {
            int i = 0;
            while (i < 1000) {
                reentrantLock.lock();
                System.out.println("producer get lock");
                linkedList.push(i++);
                System.out.println("producer add = " + i);
                System.out.println("linkedList size = " + linkedList.size());
                if (i % 100 == 0) {
                    reentrantLock.unlock();
                }
            }
        }).start();
        // consumer
        new Thread(() -> {
            int consumed = 0;
            while (consumed < 1000) {
                reentrantLock.lock();
                System.out.println("consumer get lock");
                System.out.println("consumer = " + linkedList.pop());
                consumed++;
                if (linkedList.isEmpty()) {
                    reentrantLock.unlock();
                }
            }
        }).start();
    }
}
