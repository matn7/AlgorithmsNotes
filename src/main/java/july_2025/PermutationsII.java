package july_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {1, 1, 2};

        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> result = permutationsII.permuteUnique(nums);
        System.out.println(result);
    }

    // O(n! * n) time | O(n! * n) space
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> part = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        backtrack(nums, pick, part, result);

        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, boolean[] pick, List<Integer> part, Set<List<Integer>> result) {
        if (part.size() == nums.length) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                part.add(nums[i]);
                backtrack(nums, pick, part, result);
                pick[i] = false;
                part.remove(part.size() - 1);
            }
        }
    }

}
