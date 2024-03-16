package october_2023;

import javax.swing.*;

public class OptimizedListSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int start = 2;
        int end = 5;

        OptimizedListSum optimizedListSum = new OptimizedListSum(nums);

        System.out.println(optimizedListSum.fastSum(start, end));
    }

    int[] sums;

    public OptimizedListSum(int[] sums) {
        listSum(sums);
    }

    // O(1) time | O(1) space
    public int fastSum(int start, int end) {
        return sums[end] - sums[start];
    }

    // O(n) time | O(n) space
    private int[] listSum(int[] nums) {
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = sum;
            sum += nums[i];
        }

        return sums;
    }

}
