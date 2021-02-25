package com.xh.juc;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/23 14:47
 * @description
 */
public class FizzBuzz2 {
    private int n;
    private int i=1;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        print((num)->num%3==0&&num%5!=0,(x)->printFizz.run());
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        print((num)->num%3!=0&&num%5==0,(x)->printBuzz.run());
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        print((num)->num%3==0&&num%5==0,(x)->printFizzBuzz.run());
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        print((num)->num%3!=0&&num%5!=0,printNumber);
    }

    private  synchronized void print(IntPredicate predicate,IntConsumer intConsumer) throws InterruptedException {
        // 不用 for. 利用类变量可以少很多次循环？
        while (i<=n){
            if (predicate.test(i)){
                intConsumer.accept(i);
                i++;
                this.notifyAll();
            }else {
                this.wait();
            }
        }
        this.notifyAll();
    }
}
