package july_2025;

public class TwoSumII {

    // O(n) time | O(1) space
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (target == sum) {
                return new int[] {l, r};
            } else if (target > sum) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {};
    }

}
