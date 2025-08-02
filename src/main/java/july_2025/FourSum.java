package july_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSum(nums, target);
        System.out.println(result);

    }

    // O(n^3) time | O(n) space
    List<Integer> quad = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        kSum(4, 0, target, nums);
        return res;
    }

    private void kSum(int k, int start, long target, int[] nums) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                quad.add(nums[i]);
                kSum(k - 1, i + 1, target - nums[i], nums);
                quad.remove(quad.size() - 1);
            }
            return;
        }
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            long sum = (long) nums[l] + (long) nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                List<Integer> temp = new ArrayList<>(quad);
                temp.add(nums[l]);
                temp.add(nums[r]);
                res.add(temp);
                l++;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
            }
        }
    }


}
