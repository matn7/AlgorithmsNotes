package april_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations2 permutations2 = new Permutations2();
        List<List<Integer>> result = permutations2.permute(nums);
        System.out.println(result);
    }

    // O(n! * n) time | O(n! * n) space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            curr.add(nums[i]);

            helper(nums, used, curr, result);

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }



}
