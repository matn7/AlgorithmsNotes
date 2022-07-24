package coursera.stacksandqueues;

public class ResizingArrayStackOfStrings {

    private String[] s;
    private int n = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // double size of array s[] when array is full
    // O(n) time amortized
    public void push(String item) {
        if (n == s.length) {
            resize(2 * s.length);
        }
        s[n++] = item;
    }

    // halve size of array s[] when array is one-quarter full
    public String pop() {
        String item = s[--n];
        s[n] = null; // avoids "loitering": GC can reclaim memory only if no outstanding reference
        if (n > 0 && n == s.length / 2) {
            resize(s.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

}
