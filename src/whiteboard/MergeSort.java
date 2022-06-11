package whiteboard;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};;
        mergeSort(array);
    }

    // O(nlog(n)) time | O(n) space
    public static int[] mergeSort(int[] array) {
        // Write your code here.
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] leftHalf = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = array[i];
        }

        int[] rightHalf = new int[array.length - mid];
        int counter = 0;
        for (int i = mid; i < array.length; i++) {
            rightHalf[counter] = array[i];
            counter++;
        }
        return mergeSortedArray(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private static int[] mergeSortedArray(int[] left, int[] right) {
        int[] sortedArray = new int[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sortedArray[k] = left[i];
                i++;
            } else {
                sortedArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            sortedArray[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            sortedArray[k] = right[j];
            j++;
            k++;
        }

        return sortedArray;
    }


}
