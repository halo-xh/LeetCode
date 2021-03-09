package com.xh.juc;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        TestClass testClass = new TestClass();
        Thread t0 = new Thread(testClass, "t0");
        t0.start();
        Thread t1 = new Thread(testClass, "t1");
        t1.start();
//        t0.interrupt();
        TimeUnit.SECONDS.sleep(9);
        System.out.println("t0.isAlive() = " + t0.isAlive());
        System.out.println("t1.isAlive() = " + t1.isAlive());
    }


    private static class TestClass implements Runnable {

        final Object object = new Object();

        @Override
        public void run() {
            try {
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end.");
        }


        /**
         * 一个需要注意的地方是，在共享变量上调用notifyAll（）方法只会唤醒调用这个方法前调用了wait系列函数而被放入共享变量等待集合里面的线程。
         * 如果调用notifyAll（）方法后一个线程调用了该共享变量的wait（）方法而被放入阻塞集合，则该线程是不会被唤醒的。
         */
        private void print() throws InterruptedException {
            synchronized (object) {
                System.out.println();
                String threadname = Thread.currentThread().getName();
                System.out.println(threadname);
                System.out.println(threadname + " not wait.");
                TimeUnit.SECONDS.sleep(2);
                if ("t0".equals(threadname)) {
                    System.out.println(threadname + " notify.");
                    object.notify();
                }
                System.out.println(threadname + " wait.");
                object.wait();
            }
        }
    }


}
