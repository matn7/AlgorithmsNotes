package august_2024;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arrNum = {6, 5, 2, 1, 9, 10, 0};

        System.out.println(Arrays.toString(arrNum));
        bSort(arrNum);
        System.out.println(Arrays.toString(arrNum));
    }

    public static void bSort(int[] arr) {

        //                 j
        // [2, 1, 5, 6, 0, 9, 10]
        //  i              s   s
        //

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] <= arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
