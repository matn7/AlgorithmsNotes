package coursera.stacksandqueues;

import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item> {

    private Item[] s;
    private int n = 0;

    public StackArray() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // double size of array s[] when array is full
    // O(n) time amortized
    public void push(Item item) {
        if (n == s.length) {
            resize(2 * s.length);
        }
        s[n++] = item;
    }

    // halve size of array s[] when array is one-quarter full
    public Item pop() {
        Item item = s[--n];
        s[n] = null; // avoids "loitering": GC can reclaim memory only if no outstanding reference
        if (n > 0 && n == s.length / 2) {
            resize(s.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = n;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            // not supported
        }

        public Item next() {
            return s[--i];
        }
    }
}
