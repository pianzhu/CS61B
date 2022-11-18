public class ArrayDeque<Item> {
    private Item[] value;
    private int ssize;
    private int head;
    private int length;
    private int tail;
    public ArrayDeque() {
        value = (Item[])new Object[8];
        ssize = 0;
        head = 0;
        tail = 0;
        length = 8;
    }
    public void addFirst(Item item) {
        if (ssize > length) {
            return;
        }
        head--;
        if (head < 0) {
            head = 7;
        }
        value[head] = item;
        ssize++;
    }
    public void addLast(Item item) {
        if (ssize > length) {
            return;
        }
        value[tail] = item;
        tail++;
        if (tail >= 8) {
            tail = 0;
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
        while(node != tail) {
            System.out.print(value[node] + " ");
            node++;
            if (node >= 8) {
                node = 0;
            }
        }
    }
    public Item removeFirst() {
        if (ssize ==0) {
            return null;
        }
        Item tmp = value[head];
        head++;
        if (head >= 8) {
            head = 0;
        }
        ssize--;
        return tmp;
    }
    public Item removeLast() {
        if (size()==0) {
            return null;
        }
        tail--;
        ssize--;
        return value[tail];
    }
    public Item get(int index) {
        int node = head;
        for (int i = 0; i <= index; i++) {
            node++;
            if (node >= 8) {
                node = 0;
            }
        }
        return value[node];
    }
}
