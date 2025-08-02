package july_2025;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets2 subsets2 = new Subsets2();
        List<List<Integer>> result = subsets2.subsets(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        backtrack(nums, 0, part, result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> part, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }
        part.add(nums[i]);
        backtrack(nums, i + 1, part, result);
        part.remove(part.size() - 1);
        backtrack(nums, i + 1, part, result);
    }

}
