package september_2023;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        int[] result = mergeSort(array);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static int[] mergeSort(int[] array) {
        // Write your code here.
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - mid];
        int counter = 0;
        for (int i = mid; i < array.length; i++) {
            right[counter] = array[i];
            counter++;
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0; // leftIdx
        int j = 0; // rightIdx
        int k = 0; // resIdx
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

}
