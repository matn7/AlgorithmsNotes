package december_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};

        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        helper(0, nums, curSet, subsets);
        return subsets;
    }

    private void helper(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subsets) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[i]);
        helper(i + 1, nums, curSet, subsets);
        curSet.remove(curSet.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        helper(i + 1, nums, curSet, subsets);
    }

}
