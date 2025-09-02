package august_2025;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> curr = new ArrayList<>(result.get(j));
                curr.add(nums[i]);
                result.add(curr);
            }
        }

        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> part, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(part));
            return;
        }

        part.add(nums[i]);
        backtrack(nums, i + 1, part, res);
        part.remove(part.size() - 1);
        backtrack(nums, i + 1, part, res);
    }

}
