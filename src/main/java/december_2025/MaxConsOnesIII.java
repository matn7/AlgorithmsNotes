package december_2025;

public class MaxConsOnesIII {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        MaxConsOnesIII maxConsOnesIII = new MaxConsOnesIII();
        int result = maxConsOnesIII.longestOnes(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxLen = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

}
