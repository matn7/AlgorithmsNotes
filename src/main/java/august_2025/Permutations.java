package august_2025;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);

        System.out.println(result);
    }

    // O(n * n!) time | O(n * n!) space
    public List<List<Integer>> permute(int[] nums) {
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

        for (int j = 0; j < nums.length; j++) {
            if (!pick[j]) {
                pick[j] = true;
                part.add(nums[j]);

                backtrack(nums, pick, part, result);

                pick[j] = false;
                part.remove(part.size() - 1);
            }
        }
    }

}
