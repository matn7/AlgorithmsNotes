package march_2025;

public class NumArray2 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    private int[] nums;
    public NumArray2(int[] nums) {
        this.nums = nums;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return nums[right];
        }
        return nums[right] - nums[left - 1];
    }

}
