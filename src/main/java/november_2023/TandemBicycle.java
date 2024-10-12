package november_2023;

import java.util.Arrays;

public class TandemBicycle {
    public static void main(String[] args) {
        int[] red = {5, 5, 3, 9, 2};
        int[] blue = {3, 6, 7, 2, 1};

        System.out.println(tandemBicycle(red, blue, false));

    }

    // O(nlog(n)) time | O(n) space
    public static int tandemBicycle(int[] red, int[] blue, boolean fastest) {
        // [5, 5, 3, 9, 2] -> [2, 3, 5, 5, 9]
        // [3, 6, 7, 2, 1] -> [7, 6, 3, 2, 1]

        Arrays.sort(red);
        Arrays.sort(blue);
        if (fastest) {
            reverse(blue);
        }
        int sum = 0;
        for (int i = 0; i < red.length; i++) {
            sum += Math.max(red[i], blue[i]);
        }

        return sum;
    }

    private static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
