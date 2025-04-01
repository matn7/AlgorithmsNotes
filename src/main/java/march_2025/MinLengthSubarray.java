package march_2025;

public class MinLengthSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 6;

        MinLengthSubarray minLengthSubarray = new MinLengthSubarray();
        int result = minLengthSubarray.minLenSub(nums, target);
        System.out.println(result);
    }

    public int minLenSub(int[] nums, int target) {
        int min = Integer.MAX_VALUE;

        int sum = 0;
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];
            while (sum >= target) {
                min = Math.min(min, R - L + 1);
                sum -= nums[L];
                L++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
