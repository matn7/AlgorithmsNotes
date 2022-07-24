package coursera.elementarysorts;

public class Selection {

    public static void main(String[] args) {
        Integer[] array = {8, 1, 5, 6, 8, 9, 0};
        sort(array);
        System.out.println();
    }

    // O(n^2) time
    // not stable - long distance exchange might move an item past some equal item
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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
