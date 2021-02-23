package com.xh.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/22 16:30
 * @description
 */
public class FizzBuzz {
    private int n;

    Semaphore semaphore3 = new Semaphore(0);
    Semaphore semaphore5 = new Semaphore(0);
    Semaphore semaphore35 = new Semaphore(0);
    Semaphore semaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n && i % 5 != 0; i += 3) {
            semaphore3.acquire();
            printFizz.run();
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n && i % 3 != 0; i += 5) {
            semaphore5.acquire();
            printBuzz.run();
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i += 15) {
            semaphore35.acquire();
            printFizzBuzz.run();
            semaphore.release();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphore.acquire();
            if (n % 3 == 0 && n % 5 == 0) {
                semaphore35.release();
            } else if (n % 5 == 0) {
                semaphore5.release();
            } else if (n % 3 == 0) {
                semaphore3.release();
            } else {
                printNumber.accept(i);
                semaphore.release();
            }
        }
    }

}
