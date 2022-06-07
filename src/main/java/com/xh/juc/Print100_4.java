package com.xh.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author  Xiao Hong
 * date  2021/2/24 20:35
 * description
 * <p>
 * fixme.两个线程交替打印0-100. 这方法有问题
 */
public class Print100_4 {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (i <= 100) {
                if (atomicInteger.compareAndSet(i, i + 1)) {
                    System.out.println("thread 1 --> i = " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i += 2;
                }
            }
        }).start();

        new Thread(() -> {
            int i = 1;
            while (i <= 100) {
                if (atomicInteger.compareAndSet(i, i + 1)) {
                    System.out.println("thread 2 --> i = " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i += 2;
                }
            }
        }).start();
    }


}
