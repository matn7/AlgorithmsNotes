package november_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -4, -3};
        int target = 0;

        List<Integer[]> result = threeSums(arr, target);
    }

    // O(n^2) time | O(n) space
    public static List<Integer[]> threeSums(int[] arr, int target) {
        List<Integer[]> result = new ArrayList<>();

        // [-1, 0, 1, 2, -4, -3]
        Arrays.sort(arr);
        // [-4, -3, -1, 0, 1, 2]
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int second = arr[left];
                int third = arr[right];
                int sum = first + second + third;
                if (sum == target) {
                    result.add(new Integer[] {first, second, third});
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

}
