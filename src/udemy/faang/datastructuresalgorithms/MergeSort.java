package udemy.faang.datastructuresalgorithms;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 19, 7, 1 ,22, 891, 0, 14, 78};

        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.mergeSort(array);
        System.out.println();
    }

    // O(nlog(n)) time | O(n) space
    public int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int midIdx = array.length / 2;
        int[] left = new int[array.length / 2];

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

    private int[] merge(int[] left, int[] right) {
        int k = 0;
        int i = 0;
        int j = 0;
        int[] result = new int[left.length + right.length];
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
            k++;
            i++;
        }
        while (j < right.length) {
            result[k] = right[j];
            k++;
            j++;
        }
        return result;
    }

}
