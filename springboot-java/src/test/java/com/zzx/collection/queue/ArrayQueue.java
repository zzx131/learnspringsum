package com.zzx.collection.queue;

import org.junit.Test;

/**
 * 用数组来模拟队列
 */
public class ArrayQueue {
    private int maxSize = 3;
    private int front = -1;// 队列的前
    private int rear = -1;// 队列的尾
    public int[] array = new int[maxSize];

    /**
     * 入队
     *
     * @param parm
     */
    public void addQueue(int parm) {
        rear++;
        if (rear > maxSize - 1) {
            System.out.println("队列已满了，无法添加");
            return;
        }
        array[rear] = parm;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    /**
     * 出队
     *
     * @return
     */
    public int getQueue() {
        front++;
        if (isEmpty()) {
            System.out.println("队列为空！");
            return -1;
        }
        int parm = array[front];
        return parm;
    }

    @Test
    public void testMain() {
        // 添加队列
        this.addQueue(10);
        this.addQueue(20);
        this.addQueue(30);
        this.addQueue(40);
        // 取出队列
        for (int i = 0; i < 4; i++) {
            System.out.println("取出队列中的值" + this.getQueue());
        }
    }
}
