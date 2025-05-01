package april_2025;

public class NumArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        NumArray numArray = new NumArray(nums);
        int result = numArray.sumRange(2, 5);
        System.out.println(result);
    }

    int[] nums;
    int[] pre;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }
    }

    // O(n) time | O(n) space
    public int sumRange(int left, int right) {
        if (left == 0) {
            return pre[right];
        }

        return pre[right] - pre[left - 1];
    }

}
