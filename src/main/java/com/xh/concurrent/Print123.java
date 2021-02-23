package com.xh.concurrent;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/22 9:08
 *
 * 三条线程 循环打印123123123123
 *
 */
public class Print123 {

    public static volatile int cid = 1;

    public static void main(String[] args) {

        new Thread(()->{
            final int id = 1;
            while (true){
                if (id == cid){
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 1; i < 4; i++) {
                        System.out.print(i);
                    }
                    cid = 2;
                }
            }
        }).start();
        new Thread(()->{
            final int id = 2;
            while (true){
                if (id == cid){
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 1; i < 4; i++) {
                        System.out.print(i);
                    }
                    cid = 3;
                }
            }
        }).start();
        new Thread(()->{
            final int id = 3;
            while (true){
                if (id == cid){
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 1; i < 4; i++) {
                        System.out.print(i);
                    }
                    cid = 1;
                }
            }
        }).start();

    }


}
