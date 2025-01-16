package november_2024;

import august_2024.FrequentSubtree;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
        System.out.println(result);
    }

    // ********
    // * STAR *
    // ********

    // O(n*2^n) time
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(0, new ArrayList<>(), nums, result);

        return result;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // all subsets that include nums[i]
        subset.add(nums[i]);
        backtrack(i + 1, subset, nums, result);
        subset.remove(subset.size() - 1);

        // all subsets that don't include nums[i]
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1, subset, nums, result);
    }


}
