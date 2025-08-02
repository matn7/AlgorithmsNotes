package july_2025;

public class NumArray2 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(nums);
        int result = numArray.sumRange(0, 2);
        System.out.println(result);
    }

    // intuition:
    // brute force - nested loops, prefix sum
    // approach:
    // pre-calc prefixSum - use formula
    // complexity: O(n) time | O(n) space -> create prefix sum
    // O(1) time -> sumRange

    int[] prefixSum;

    public NumArray2(int[] nums) {
        this.prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            this.prefixSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.prefixSum[right];
        }
        return this.prefixSum[right] - this.prefixSum[left - 1];
    }

}
