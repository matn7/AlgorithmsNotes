package educative.twopointers;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    // O(n) time | O(1) space
    public static void sort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        for (int i = 0; i <= high;) {
            if (array[i] == 0) {
                swap(array, i, low);
                i++;
                low++;
            } else if (array[i] == 1) {
                i++;
            } else {
                swap(array, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
