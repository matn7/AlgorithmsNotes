package coursera.elementarysorts;

public class MergeBU {

    public static void main(String[] args) {
        Integer[] array = {8, 1, 5, 6, 8, 9, 0, 89, 9, 654, 0, 216576, 6, 23, 11, 5624};
        sort(array);
        System.out.println();
    }

    static Comparable[] aux;

    // bottom-up mergesort
    private static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    private static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


}
