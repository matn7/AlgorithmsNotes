package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        SubsetsWithDup subsets = new SubsetsWithDup();
        List<List<Integer>> result = subsets.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i > nums.length) {
            return;
        }
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, result);
        subset.remove(subset.size() - 1);
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }
        backtrack(nums, i + 1, subset, result);
    }
}
