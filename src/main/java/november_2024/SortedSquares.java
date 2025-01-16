package november_2024;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        SortedSquares sortedSquares = new SortedSquares();
        int[] ints = sortedSquares.sortedSquares(nums);
        System.out.println(ints);
    }

    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int idx = nums.length - 1;
        int[] res = new int[nums.length];

        while (idx >= 0) {
            int a = nums[l] * nums[l];
            int b = nums[r] * nums[r];

            if (a < b) {
                res[idx] = b;
                r--;
            } else {
                res[idx] = a;
                l++;
            }
            idx--;
        }
        return res;
    }

}
