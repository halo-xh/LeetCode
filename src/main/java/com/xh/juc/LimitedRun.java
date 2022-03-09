package com.xh.juc;

import java.util.concurrent.TimeUnit;

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
        TimeUnit.SECONDS.timedJoin(thread, 5);
        thread.interrupt();

        Object o = new Object();
        new Thread(() -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
