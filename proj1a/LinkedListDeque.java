public class LinkedListDeque<T> {
    private Node sentinel;
    private int ssize;
    class Node {
        private T value;
        private Node pre;
        private Node next;
        public Node(T T, Node pre, Node next) {
            value = T;
            this.pre = pre;
            this.next = next;
        }
        public Node(Node pre, Node next) {
            this.pre = pre;
            this.next = next;
        }
    }
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        ssize = 0;
    }
    public void addFirst(T T) {
        Node node = new Node(T, sentinel, sentinel.next);
        node.next.pre = node;
        sentinel.next = node;
        ssize++;
    }
    public void addLast(T T) {
        Node node = new Node(T, sentinel.pre, sentinel);
        sentinel.pre.next = node;
        sentinel.pre = node;
        ssize++;
    }
    public boolean isEmpty() {
        return ssize == 0;
    }
    public int size() {
        return ssize;
    }
    public void printDeque() {
        Node node = sentinel.next;
        while (node != sentinel) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        T ret = sentinel.next.value;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        ssize--;
        return ret;
    }
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        T ret = sentinel.pre.value;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        ssize--;
        return ret;
    }
    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        Node node = sentinel;
        int i = 0;
        while (i <= index) {
            node = node.next;
            i++;
        }
        return node.value;
    }
    private T recursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.value;
        }
        return recursiveHelper(index - 1, node.next);
    }
    public T getRecursive(int index) {
        if (index >= size()) {
            return null;
        }
        return recursiveHelper(index, sentinel.next);
    }
}
