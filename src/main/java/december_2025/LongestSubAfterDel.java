package december_2025;

public class LongestSubAfterDel {

    public static void main(String[] args) {
//        int[] nums = {0,1,1,1,0,1,1,0,1};

        int[] nums = {1,1,0,1};
        LongestSubAfterDel longestSubAfterDel = new LongestSubAfterDel();
        int result = longestSubAfterDel.longestSubarray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroesCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroesCount++;
            }

            while (zeroesCount > 1) {
                if (nums[left] == 0) {
                    zeroesCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}
