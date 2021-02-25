package com.xh.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar2 {
    private int n;

    ReentrantLock lk = new ReentrantLock(true);
    private Condition condition = lk.newCondition();
    private volatile boolean flag = true;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
            lk.lock();
            try {
                while(!flag) {
                    condition.await();
                }
                printFoo.run();
                flag = false;
                condition.signal();
            }finally {
                lk.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lk.lock();
            try {
                while (flag){
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                condition.signal();
            }finally {
                lk.unlock();
            }
        }
    }
}
