package june_2025;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 5};
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, 0, oneRes, result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> oneRes, List<List<Integer>> res ) {
        if (i == nums.length) {
            res.add(new ArrayList<>(oneRes));
            return;
        }
        oneRes.add(nums[i]);
        backtrack(nums, i + 1, oneRes, res);
        oneRes.remove(oneRes.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums, i + 1, oneRes, res);
    }


}
