package indi.structures.stack;

import java.util.EmptyStackException;

public class SeqStack<T> implements Stack<T> {
    private int top = -1;

    private T[] array;

    private int size;

    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    @SuppressWarnings("unchecked")
    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) {
        if (capacity < size)
            return;
        T[] old = array;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        if (size >= 0) System.arraycopy(old, 0, array, 0, size);
    }

    @Override
    public boolean find(T obj) {
        if (isEmpty()) return false;
        final int tmp = top;
        for (int i = 0; i < tmp; i++) {
            if (array[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {
        if (array.length == size) {
            ensureCapacity(size * 2 + 1);
        }
        array[++top] = data;
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        size--;
        return array[top--];
    }
}
