package com.grove.leetcode.app;

/**
 * 622. 设计循环队列
 */
public class MyCircularQueue {

    private int[] arr;

    private int count;

    private int head;

    private int capacity;

    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.count = 0;
        this.head = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (count == capacity) {
            return false;
        }
        this.arr[(head+count)%capacity] = value;
        this.count +=1;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        this.count -= 1;
        this.head = (head+1)%capacity;
        return true;
    }

    public int Front() {
        if (count == 0) {
            return -1;
        }
        return this.arr[head];
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return this.arr[(head+count-1)%capacity];
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (count == capacity) {
            return true;
        }
        return false;
    }

}
