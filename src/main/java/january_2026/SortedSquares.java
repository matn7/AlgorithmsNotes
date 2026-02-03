package january_2026;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        SortedSquares sortedSquares = new SortedSquares();
        int[] result = sortedSquares.sortedSquares(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int L = 0;
        int R = nums.length - 1;
        int idx = R;
        while (L <= R) {
            int numL = nums[L] * nums[L];
            int numR = nums[R] * nums[R];

            if (numR > numL) {
                result[idx] = numR;
                R--;
            } else {
                result[idx]= numL;
                L++;
            }
            idx--;
        }

        return result;
    }


}
