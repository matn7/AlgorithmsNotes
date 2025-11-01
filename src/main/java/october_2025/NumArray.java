package october_2025;

public class NumArray {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }

    int[] newNums;

    // O(n) time | O(1) space
    public NumArray(int[] nums) {
        this.newNums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            this.newNums[i] = sum;
        }
    }

    // O(1) time | O(1) space
    public int sumRange(int left, int right) {
        if (left == 0) {
            return newNums[right];
        }
        return newNums[right] - newNums[left - 1];
    }

}
