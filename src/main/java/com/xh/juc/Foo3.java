package com.xh.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 * <p>
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * <p>
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 有问题这个
 */
public class Foo3 {

    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);

    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Foo3 foo2 = new Foo3();
        new Thread(()-> {
            try {
                foo2.third(()-> System.out.println("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                foo2.second(()-> System.out.println("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                foo2.first(()-> System.out.println("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
