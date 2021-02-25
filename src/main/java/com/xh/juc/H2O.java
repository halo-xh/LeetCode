package com.xh.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 *
 * 栅栏为 3 , 通过semaphore 的值进行限定.
 */
public class H2O {

    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(1);

    CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
        semaphoreH.release(2);
        semaphoreO.release(1);
    });

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreO.acquire();
        releaseOxygen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}

