package december_2025;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
//        int k = 2;

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        int result = maxConsecutiveOnesIII.longestOnes(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int used = 0;
        int maxLen = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                used++;
            }
            while (used > k) {
                if (nums[l] == 0) {
                    used--;
                }
                l++;
            }
            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }
        return maxLen;
    }

}
