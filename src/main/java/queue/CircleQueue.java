package main.java.queue;

/**
 * author  Xiao Hong
 * date  2021/1/24 12:58
 * description 双端队列
 */

public class CircleQueue<E> {

    // 记录当前存的元素个数
    int size;
    // 记录头的index
    int front;
    // 对列长度
    int capacity;

    private final E[] elements = (E[]) new Object[capacity];

    public CircleQueue(int capibility) {
        this.capacity = capibility;
    }

    public int size() {
        return size;
    }

    public E deQueue() {
        E re = elements[front];
        size--;
        front = (front + 1) % capacity; // 取模
        return re;
    }

    public void enQueue(E e) {
        elements[(front + size) % capacity] = e;  // 取模
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
