package indi.structures;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev = null;

    public Node(){}

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this(data);
        this.next = next;
    }

    public Node(T data, Node<T> prev, Node<T> next) {
        this(data, next);
        this.prev = prev;
    }
}
