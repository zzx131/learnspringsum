package com.zzx.collection.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    /**
     * corePoolSize：核心线程池的大小，如果核心线程池有空闲位置，这是新的任务就会被核心线程池新建一个线程执行，执行完毕后不会销毁线程，线程会进入缓存队列等待再次被运行
     * maximunPoolSize：线程池能创建最大的线程数量。如果核心线程池和缓存队列都已经满了，
     * 新的任务进来就会创建新的线程来执行。但是数量不能超过maximunPoolSize，否侧会采取拒绝接受任务策略，我们下面会具体分析。
     * keepAliveTime：非核心线程能够空闲的最长时间，超过时间，线程终止。这个参数默认只有在线程数量超过核心线程池大小时才会起作用。只要线程数量不超过核心线程大小，就不会起作用。
     * unit：时间单位，和keepAliveTime配合使用。
     * workQueue：缓存队列，用来存放等待被执行的任务。
     * <p>
     * threadFactory：线程工厂，用来创建线程，一般有三种选择策略。
     * ArrayBlockingQueue;
     * LinkedBlockingQueue;
     * SynchronousQueue;
     */
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            pool.execute(task);
            System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                    pool.getQueue().size() + "，已执行玩别的任务数目：" + pool.getCompletedTaskCount());
        }
        pool.shutdown();
    }
}
