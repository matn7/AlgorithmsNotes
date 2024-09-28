package august_2024;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arrNum = {6, 5, 2, 1, 9, 10, 0};
        System.out.println(Arrays.toString(arrNum));
        sSort(arrNum);
        System.out.println(Arrays.toString(arrNum));
    }

    public static void sSort(int[] arr) {

        //  i
        // [6, 5, 2, 1, 9, 10, 0]
        //           m

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
