package hard;

import java.util.Arrays;

public class ShiftedBinarySearch {


    public static void main(String[] args) {
//        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
//        int[] array = {0, 1, 21, 33, 37, 45, 61, 71, 72, 73};
        int[] array = {5, 23, 111, 1};
        int result = shiftedBinarySearch(array, 111);
        System.out.println(result);
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int shiftBy = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                shiftBy++;
                break;
            }
            shiftBy++;
        }

        if (shiftBy == array.length) {
            shiftBy = 0;
        }

        int min = 0;
        int max = array.length - 1;

        Arrays.sort(array);

        while (min <= max) {
            int mid = (max + min) / 2;
            if (array[mid] == target) {
                return (mid + shiftBy) % array.length;
            } else if (array[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }
}
