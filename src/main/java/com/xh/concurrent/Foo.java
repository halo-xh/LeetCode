package com.xh.concurrent;

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
public class Foo {

    private volatile int next = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (next != 1) {
            ;
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        next = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (next != 2) {
            ;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        next = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (next != 3) {
            ;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
