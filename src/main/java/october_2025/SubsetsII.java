package october_2025;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2};
        int[] nums = {4,4,4,1,4};

        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, result);
        return new ArrayList<>(result);
    }

    private void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]); // include
        helper(nums, i + 1, subset, result);
        subset.remove(subset.size() - 1); // not include
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        helper(nums, i + 1, subset, result);
    }

}
