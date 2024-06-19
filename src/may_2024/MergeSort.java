package may_2024;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};

        int[] result = mergeSort(array);
        System.out.println();
    }

    // O(nlog(n)) time | O(n) space
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int midIdx = array.length / 2;
        int[] left = new int[midIdx];
        for (int i = 0; i < midIdx; i++) {
            left[i] = array[i];
        }
        int[] right = new int[array.length - midIdx];
        int counter = 0;
        for (int i = midIdx; i < array.length; i++) {
            right[counter] = array[i];
            counter++;
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
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
