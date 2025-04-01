package march_2025;

import java.util.Arrays;

public class LongestIncreasingSubsequenceII {

    public static void main(String[] args) {
        int[] nums = {4,2,1,4,3,4,5,8,15};
        int k = 3;

        LongestIncreasingSubsequenceII longestIncreasingSubsequenceII = new LongestIncreasingSubsequenceII();
        int result = longestIncreasingSubsequenceII.lengthOfLIS(nums, k);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums, int k) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        SegmentTree ST = SegmentTree.build(nums, 0, maxVal - 1);
        int res = 0;
        for (int num : nums) {
            int l = Math.max(0, num - k);
            int r = Math.max(0, num - 1);
            int curr = ST.rangeQuery(l, r) + 1;
            res = Math.max(res, curr);
            ST.update(num, curr);
        }
        return res;
    }

    // O(n^2) time | O(n) space
    public int lengthOfLIS2(int[] nums, int k) {
        int[] seq = new int[nums.length];
        Arrays.fill(seq, 1);
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                    seq[j] = Math.max(seq[j], seq[i] + 1);
                }
            }
            max = Math.max(max, seq[i]);
        }
        return max;
    }

}

