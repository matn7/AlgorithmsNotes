package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};

        List<Integer[]> result = threeNumberSum(array, 0);
        System.out.println();
    }

    // O(n^2) time | O(n) space
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        if (array.length < 3) {
            return new ArrayList<>();
        }

        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);

        for (int idx = 0; idx < array.length - 2; idx++) {
            int currVal = array[idx];
            int left = idx + 1;
            int right = array.length - 1;
            while (left < right) {
                int leftVal = array[left];
                int rightVal = array[right];
                int currSum = currVal + leftVal + rightVal;
                if (currSum < targetSum) {
                    left++;
                } else if (currSum > targetSum) {
                    right--;
                } else {
                    Integer[] res = {currVal, leftVal, rightVal};
                    result.add(res);
                    left++;
                    right--;
                }
            }
        }

        return result;
    }

}
