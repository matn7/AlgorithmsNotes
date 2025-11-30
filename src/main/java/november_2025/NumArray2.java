package november_2025;

public class NumArray2 {

    int[] nums;

    // O(n) time | O(n) space
    public NumArray2(int[] nums) {
        this.nums = new int[nums.length];
        this.nums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] = this.nums[i - 1] + nums[i];
        }
    }

    // O(1) time | O(1) space
    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.nums[right];
        }
        return this.nums[right] - this.nums[left - 1];
    }


}
