package com.example.eurekaserver.rate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 滑动窗口限流算法
 */
public class SlidingWindowLimitAlg {

    /**
     * 循环队列实现滑动窗口
     */
    private final CircularQueue circularQueue;
    private static final long lock_timeout = 200L;  // 200ms.
    private static final Lock lock = new ReentrantLock();

    public SlidingWindowLimitAlg(int limit) {
        this.circularQueue = new CircularQueue(limit);
    }

    public boolean tryAcquire() throws Exception {
        if (lock.tryLock(lock_timeout, TimeUnit.MILLISECONDS)) {
            // 有加锁，就有解锁
            try {
                // 先去掉距离当前时间阈值为 1 min 内的请求数据
                while (this.circularQueue.firstElement() != null
                        && (System.currentTimeMillis() - this.circularQueue.firstElement() > 60 * 1000)) {
                    // 超时数据踢掉
                    this.circularQueue.dequeue();
                }
                return this.circularQueue.enqueue(System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }
        return false;
    }


    public static class CircularQueue {
        // 数组：items，数组大小：n
        private final Long[] items;
        private int n = 0;
        // head表示队头下标，tail表示队尾下标
        private int head = 0;
        private int tail = 0;

        // 申请一个大小为capacity的数组
        public CircularQueue(int capacity) {
            items = new Long[capacity];
            n = capacity;
        }

        // 入队
        public boolean enqueue(Long item) {
            // 队列满了
            if ((tail + 1) % n == head) return false;
            items[tail] = item;
            tail = (tail + 1) % n;
            return true;
        }

        // 出队
        public Long dequeue() {
            // 如果head == tail 表示队列为空
            if (head == tail) return null;
            Long ret = items[head];
            head = (head + 1) % n;
            return ret;
        }

        // 最老元素
        public Long firstElement() {
            // 如果head == tail 表示队列为空
            if (head == tail) return null;
            return items[head];
        }
    }

}
