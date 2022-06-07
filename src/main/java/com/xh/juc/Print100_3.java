package com.xh.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author  Xiao Hong
 * date  2021/2/24 20:35
 * description
 * <p>
 * 两个线程交替打印0-100
 */
public class Print100_3 {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i <= 100; i += 2) {
                lock.lock();
                try {
                    condition.signal();
                    System.out.println("A -> "+i);
                    if ( i!= 100) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                lock.lock();
                try {
                    condition.signal();
                    System.out.println("B -> "+i);
                    if (i != 99) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();

                }
            }
        }).start();
    }


}
