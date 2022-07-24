package coursera.priorityqueues;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key x) {
        pq[n++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(pq, max, n - 1);
        return pq[--n];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}

