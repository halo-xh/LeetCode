package com.xh.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 * 先找两个H，释放O的锁, 再找一个O, 找完O 释放H 的锁, 开始下一轮
 *
 */
public class H2O2 {

    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(1);

    private volatile int hnum = 0;

    public H2O2() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hnum++;
        if (hnum==2){
            semaphoreO.release();
        }

    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreO.acquire();
        releaseOxygen.run();
        hnum=0;
        semaphoreH.release(2);
    }

}

