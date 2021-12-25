package indi.structures.list;

public class List<T> {
    private class Node<U> {
        private U item;
        private Node next;
        private Node prev;
        public Node() {}
        public Node(Node self) {
            this.next = self;
            this.prev = self;
        }
        public Node(U item, Node self) {
            this(self);
            this.item = item;
        }
    }
    private Node head;
    private Node tail;
    public List() {
        head = new Node(head);
        tail = head;
    }

    public void add(T elem) {
        var node = new Node<T>();
    }
}
