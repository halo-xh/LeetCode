package com.xh.juc;

import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 */
public class ZeroEvenOdd2 {

    private int n;

    private volatile boolean zero = true;
    private volatile boolean even = false;

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <n; i++) {
            while (!zero){
                Thread.yield();
            }
            printNumber.accept(0);
            zero = false;
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=n; i += 2) {
            while (!even || zero){
                Thread.yield();
            }
            printNumber.accept(i);
            even = false;
            zero = true;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n; i += 2) {
            while (even || zero){
                Thread.yield();
            }
            printNumber.accept(i);
            even = true;
            zero = true;
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(2);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
