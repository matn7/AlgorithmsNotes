package april_2025;

public class MaxSubarray {

    public static void main(String[] args) {
//        int[] nums = {5,4,-1,7,8};

        int[] nums = {-1};

        MaxSubarray maxSubarray = new MaxSubarray();
        int result = maxSubarray.maxSubArray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int maxHere;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            maxHere = Math.max(sum, num);
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, maxHere);
        }
        return max;
    }

}
