package may_2025;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        backtrack(nums, idx + 1, subset, result);
        subset.remove(subset.size() - 1);
        backtrack(nums, idx + 1, subset, result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }

        return result;
    }

}
