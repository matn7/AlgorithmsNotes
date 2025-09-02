package august_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> result = permutationsII.permuteUnique(nums);
        System.out.println(result);
    }

    // O(n * n!) time | O(n * n!) space
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];

        backtrack(nums, pick, part, result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] pick, List<Integer> part, List<List<Integer>> result) {
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
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }

}
