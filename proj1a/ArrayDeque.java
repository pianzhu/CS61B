public class ArrayDeque<T> {
    private T[] value;
    private int ssize;
    private int head;
    private int length;
    private int tail;
    public ArrayDeque() {
        value = (T[]) new Object[8];
        ssize = 0;
        head = 0;
        tail = 0;
        length = 8;
    }

    private void resizeUp() {
        T[] newArray = (T[]) new Object[length * 2];
        int ptr1 = head;
        int ptr2 = length;
        while (ptr1 != tail) {
            newArray[ptr2] = value[ptr1];
            ptr1++;
            if (ptr1 == length) {
                ptr1 = 0;
            }
            ptr2++;
            if (ptr2 == length) {
                ptr2 = 0;
            }
        }
        head = length;
        tail = ptr2;
        value = newArray;
        length *= 2;
    }

    private void resizeDown() {
        T[] newArray = (T[]) new Object[length / 2];
        int ptr1 = head;
        int ptr2 = length / 4;
        while (ptr1 != tail) {
            newArray[ptr2] = value[ptr1];
            ptr1++;
            if (ptr1 == length) {
                ptr1 = 0;
            }
            ptr2++;
            if (ptr2 == length / 2) {
                ptr2 = 0;
            }
        }
        head = length / 4;
        tail = ptr2;
        value = newArray;
        length /= 2;
    }
    public void addFirst(T item) {
        if (ssize == length - 1) {
            resizeUp();
        }
        head--;
        if (head < 0) {
            head = length - 1;
        }
        value[head] = item;
        ssize++;
    }
    public void addLast(T item) {
        if (ssize == length - 1) {
            resizeUp();
        }
        value[tail] = item;
        if (tail + 1 == length) {
            tail = 0;
        }
        else {
            tail++;
        }
        ssize++;
    }
    public boolean isEmpty() {
        return ssize == 0;
    }
    public int size() {
        return ssize;
    }
    public void printDeque() {
        int node = head;
        while (node != tail) {
            System.out.print(value[node] + " ");
            node++;
            if (node == length) {
                node = 0;
            }
        }
    }
    public T removeFirst() {
        if (length >= 16 && length / ssize >= 4) {
            resizeDown();
        }
        if (ssize == 0) {
            return null;
        }
        T tmp = value[head];
        if (head + 1 == length) {
            head = 0;
        }
        else {
            head++;
        }
        ssize--;
        return tmp;
    }
    public T removeLast() {
        if (length >= 16 && length / ssize >= 4) {
            resizeDown();
        }
        if (ssize == 0) {
            return null;
        }
        tail--;
        if (tail < 0) {
            tail = length - 1;
        }
        ssize--;
        return value[tail];
    }
    public T get(int index) {
        if (index >= ssize) {
            return null;
        }
        int node = head;
        for (int i = 0; i < index; i++) {
            node++;
            if (node >= 8) {
                node = 0;
            }
        }
        return value[node];
    }
}
