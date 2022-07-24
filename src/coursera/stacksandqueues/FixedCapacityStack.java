package coursera.stacksandqueues;

public class FixedCapacityStack<Item> {

    private Item[] s;
    private int n = 0;

    public FixedCapacityStack(int capacity) {
        // s = new Item[capacity];
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        s[n++] = item;
    }

    public Item pop() {
        Item item = s[--n];
        s[n] = null; // avoids "loitering": GC can reclaim memory only if no outstanding reference
        return item;
    }

}
