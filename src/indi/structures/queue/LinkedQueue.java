package indi.structures.queue;

import indi.structures.Node;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front, rear;

    private int size;

    public LinkedQueue() {
        this.front = this.rear = null;
    }

    @Override
    public boolean find(T obj) {
        if (isEmpty()) return false;
        var tmp = front;
        do {
            if (tmp.data.equals(obj)) {
                return true;
            }
            tmp = tmp.next;
        } while (tmp.next != null);
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public boolean push(T data) {
        Node<T> node = new Node<>(data, null);
        if (this.front == null) {
            this.front = node;
        } else {
            this.rear.next = node;
        }
        this.rear = node;
        size++;
        return true;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : this.front.data;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T tmp = this.front.data;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        size--;
        return tmp;
    }

    @Override
    public void clearQueue() {
        this.front = this.rear = null;
        size = 0;
    }
}
