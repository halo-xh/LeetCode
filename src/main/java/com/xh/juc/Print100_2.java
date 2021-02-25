package com.xh.concurrent;

import java.util.concurrent.Semaphore;

/**
 * author  Xiao Hong
 * date  2021/2/24 20:35
 * description
 * <p>
 * 两个线程交替打印0-100
 */
public class Print100_2 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        new Thread(printer, "A").start();
        new Thread(printer, "B").start();
    }

    private static class Printer implements Runnable {
        int i = 1;

        @Override
        public void run() {
            synchronized (this) {
                while (i != 101) {
                    this.notify();
                    System.out.println(Thread.currentThread().getName() + "->" + i++);
                    if (i == 101) {
                        break;
                    }
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
