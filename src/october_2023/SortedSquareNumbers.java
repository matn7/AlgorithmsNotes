package october_2023;

public class SortedSquareNumbers {

    public static void main(String[] args) {
        int[] nums = {-5, -3, -1, 1, 2, 4, 5};

        sortedNumbers(nums);
    }

    // O(n) time | O(n) space
    public static int[] sortedNumbers(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int idx = nums.length - 1;

        while (start < end) {
            int startVal = nums[start] * nums[start];
            int endVal = nums[end] * nums[end];
            if (startVal > endVal) {
                result[idx] = startVal;
                start++;
            } else {
                result[idx] = endVal;
                end--;
            }
            idx--;
        }
        return result;
    }

}
