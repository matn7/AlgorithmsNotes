package april_2025;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        SortedSquares sortedSquares = new SortedSquares();
        int[] result = sortedSquares.sortedSquares(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] sortedSquares(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int[] result = new int[nums.length];
        int idx = nums.length - 1;

        while (L <= R) {
            int a = nums[L] * nums[L];
            int b = nums[R] * nums[R];

            if (b > a) {
                result[idx] = b;
                R--;
            } else {
                result[idx] = a;
                L++;
            }
            idx--;
        }

        return result;
    }

}
