package coursera.elementarysorts;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] array = {8, 1, 5, 6, 8, 9, 0, 89, 9, 654, 0, 216576, 6, 23, 11, 5624};
        sort(array);
        System.out.println();
    }

    static int CUTOFF = 7;

    // best case: O(nlog(n))
    // worst: O(n^2)
    // in place constant extra space
    // not stable
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + CUTOFF - 1)
        {
            Insertion.sort(a);
            return;
        }
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }

            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    public static Comparable select(Comparable[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return a[k];
            }
        }
        return a[k];
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
