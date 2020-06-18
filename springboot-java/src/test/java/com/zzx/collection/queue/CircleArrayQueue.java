package com.zzx.collection.queue;

import org.junit.Test;

public class CircleArrayQueue {
    private int rear; // 队列头部.默认为0
    private int front;// 队列尾部.默认为0
    private int maxSize = 4;// 队列最大长度
    public int[] array = new int[maxSize]; // 数组队列

    public CircleArrayQueue() {
    }

    /**
     * 队列是否满了
     *
     * @return
     */
    public Boolean isFull() {
        if ((rear + 1) % maxSize == front) {
            return true;
        }
        return false;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        if (rear == front) {
            System.out.println("队列已满");
            return true;
        }
        return false;
    }

    /**
     * 添加队列
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加数据--");
        }
        // 添加好元素
        array[rear] = n;
        // 将rear进行后移
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出队列
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 取出队列中的元素
        int value = array[front];
        // 移动front的下标
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 数组中有多少个有效的数据
     *
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列信息
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！");
            return;
        }
        // 显示队列的信息
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, array[i % maxSize]);
        }
    }

    /**
     * 显示头部元素
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return array[front];
    }

    /**
     * 做环形队列
     */
    @Test
    public void testMain() {
        this.addQueue(10);
        this.addQueue(20);
        this.addQueue(30);

        int queue = this.getQueue();
        System.out.println(queue);
        this.showQueue();
        System.out.println("头部元素" + this.headQueue());
        this.addQueue(40);
        this.showQueue();

    }
}
