package com.xh.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author  Xiao Hong
 * date  2021/2/24 20:35
 * description
 * <p>
 * 两个线程交替打印0-100
 */
public class Print100 {

    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore semaphore2 = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i <= 100; i += 2) {
                try {
                    semaphore1.acquire();
                    System.out.println(i);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                try {
                    semaphore2.acquire();
                    System.out.println(i);
                    semaphore1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
