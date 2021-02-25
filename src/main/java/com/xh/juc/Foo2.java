package com.xh.juc;

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
 */
public class Foo2 {

    ReentrantLock lk = new ReentrantLock();
    Condition two = lk.newCondition();
    Condition three = lk.newCondition();


    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lk.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            two.signal();
        } finally {
            lk.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lk.lock();
        try {
            two.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            three.signal();
        }finally {
            lk.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lk.lock();
        try {
            three.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }finally {
            lk.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo2 foo2 = new Foo2();
        new Thread(()-> {
            try {
                foo2.first(()-> System.out.println("1"));
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
                foo2.third(()-> System.out.println("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
