package july_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(nums);
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
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, i + 1, part, result);
    }

}
