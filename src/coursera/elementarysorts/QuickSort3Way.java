package coursera.elementarysorts;

public class QuickSort3Way {

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
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);;
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

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
