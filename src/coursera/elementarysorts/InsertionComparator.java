package coursera.elementarysorts;

import java.util.Comparator;

public class InsertionComparator {

    public static void main(String[] args) {
        Integer[] array = {8, 1, 5, 6, 8, 9, 0};
//        sort(array);
        System.out.println();
    }

    public static void sort(Comparable[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
