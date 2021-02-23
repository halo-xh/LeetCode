package com.xh.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/22 9:08
 * <p>
 * 三条线程 循环打印123123123123
 */
public class Print123_2 {

    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(0);
    private static Semaphore semaphore3 = new Semaphore(0);

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    semaphore1.acquire();
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 1; i < 4; i++) {
                        System.out.print(i);
                    }
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    semaphore2.acquire();
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 1; i < 4; i++) {
                        System.out.print(i);
                    }
                    semaphore3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    semaphore3.acquire();
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 1; i < 4; i++) {
                        System.out.print(i);
                    }
                    semaphore1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
