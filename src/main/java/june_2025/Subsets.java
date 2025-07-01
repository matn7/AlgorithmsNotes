package june_2025;

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
        List<Integer> oneRes = new ArrayList<>();
        backtrack(nums, 0, oneRes, result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> oneRes, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(oneRes));
            return;
        }
        oneRes.add(nums[i]);
        backtrack(nums, i + 1, oneRes, result);
        oneRes.remove(oneRes.size() - 1);
        backtrack(nums, i + 1, oneRes, result);
    }


}
