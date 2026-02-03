package january_2026;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        int[] result = squaresOfASortedArray.sortedSquares(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int idx = nums.length - 1;
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int leftNum = nums[L] * nums[L];
            int rightNum = nums[R] * nums[R];
            if (rightNum > leftNum) {
                result[idx] = rightNum;
                R--;
            } else {
                result[idx] = leftNum;
                L++;
            }
            idx--;
        }

        return result;
    }

}
