package com.xh.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * ----------------------------
 * 四条线程，每次只有一条线程在打印。
 */
public class FizzBuzz {
    private int n;

    private volatile int type = 1;
    private volatile AtomicInteger cu = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (type == 3) {
            printFizz.run();
            type = 1;
            cu.incrementAndGet();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (type == 5) {
            printBuzz.run();
            type = 1;
            cu.incrementAndGet();

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (type == 15) {
            printFizzBuzz.run();
            type = 1;
            cu.incrementAndGet();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cu.get() <= n) {
            if (cu.get() % 3 == 0 && cu.get() % 5 == 0) {
                type = 15;
            } else if (cu.get() % 5 == 0) {
                type = 5;
            } else if (cu.get() % 3 == 0) {
                type = 3;
            } else if (type == 1) {
                printNumber.accept(cu.get());
                cu.incrementAndGet();
            }
        }
    }

}
