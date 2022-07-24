package coursera.stacksandqueues;

public class FixedCapacityStackOfStrings {

    private String[] s;
    private int n = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String item) {
        s[n++] = item;
    }

    public String pop() {
        String item = s[--n];
        s[n] = null; // avoids "loitering": GC can reclaim memory only if no outstanding reference
        return item;
    }

}
