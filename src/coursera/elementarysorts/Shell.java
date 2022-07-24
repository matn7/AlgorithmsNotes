package coursera.elementarysorts;

public class Shell {

    public static void main(String[] args) {
        Integer[] array = {8, 1, 5, 6, 8, 9, 0, 89, 9, 654, 0, 216576, 6, 23, 11, 5624};
        sort(array);
        System.out.println();
    }

    // 3x + 1 O(n^3/2) time
    // not stable - long distance exchange might move an item post some equal item
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n/3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h/3;
        }
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
