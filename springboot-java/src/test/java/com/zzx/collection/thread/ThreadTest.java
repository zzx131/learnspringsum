package com.zzx.collection.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
    /**
     * 利用join 做阻塞线程
     *
     * @throws InterruptedException
     */
    @Test
    public void testJoin() throws InterruptedException {
        Thread threadA = new Thread(() -> System.out.println("aThread"));
        Thread threadB = new Thread(() -> System.out.println("bThread"));
        Thread threadC = new Thread(() -> System.out.println("cThread"));

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("主线程");
    }

    /**
     * CountDownLach做阻塞线程 匿名内部类中添加引入外部的参数
     *
     * @throws InterruptedException
     */
    @Test
    public void testCountDownLach() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread threadA = new Thread(new Runnable() {
            private CountDownLatch countDownLatch;

            @Override
            public void run() {
                System.out.println("线程A");
                countDownLatch.countDown();
            }

            public Runnable accept(CountDownLatch countDownLatch) {
                this.countDownLatch = countDownLatch;
                return this;
            }
        }.accept(countDownLatch));

        Thread threadB = new Thread(new Runnable() {
            private CountDownLatch countDownLatch;

            @Override
            public void run() {
                System.out.println("线程B");
                countDownLatch.countDown();
            }

            public Runnable accept(CountDownLatch countDownLatch) {
                this.countDownLatch = countDownLatch;
                return this;
            }
        }.accept(countDownLatch));
        threadA.start();
        threadB.start();
        countDownLatch.await();
        System.out.println("主线程");
    }

}
