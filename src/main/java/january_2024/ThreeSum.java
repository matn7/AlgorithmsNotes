package january_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -4, -3};
        int target = 0;
        List<Integer[]> result = threeSum(nums, target);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static List<Integer[]> threeSum(int[] nums, int target) {

        List<Integer[]> result = new ArrayList<>();

        Arrays.sort(nums);
        // [-4, -3, -1, 0, 1, 2]
        //   i   s            e
        for (int i = 0; i < nums.length; i++) {
            int numA = nums[i]; // -4
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int numB = nums[start];
                int numC = nums[end];
                int sum = numA + numB + numC;
                if (sum == target) {
                    Integer[] oneRes = new Integer[3];
                    oneRes[0] = numA;
                    oneRes[1] = numB;
                    oneRes[2] = numC;
                    result.add(oneRes);
                    start++;
                    end--;
                } else if (target < sum) { // -6 < 0
                    end--;
                } else {
                    start++;
                }
            }
        }

        return result;

    }

}
