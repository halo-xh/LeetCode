package com.xh.juc;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar {

    public static void main(String[] args) {

    }

    private int n;

    Semaphore semaphoref = new Semaphore(1);
    Semaphore semaphoreb = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoref.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreb.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreb.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoref.release();
        }
    }
}
